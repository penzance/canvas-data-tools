package edu.harvard.data.client.canvas.api;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.StringJoiner;
import java.util.TimeZone;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import edu.harvard.data.client.DataConfigurationException;

public class RestUtils {

  private final String host;
  private final String key;
  private final String secret;
  private final Client client;

  public RestUtils(final String host, final String key, final String secret) {
    this.host = host;
    this.key = key;
    this.secret = secret;

    final ClientConfig cfg = new DefaultClientConfig();
    client = Client.create(cfg);
    cfg.getClasses().add(JacksonJsonProvider.class);
    client.setFollowRedirects(false);

  }

  public ClientResponse makeApiCall(final String resourcePath, final int expectedStatus)
      throws DataConfigurationException, UnexpectedApiResponseException {
    final TimeZone tz = TimeZone.getTimeZone("GMT");
    final DateFormat df = new SimpleDateFormat("E, dd MMM Y HH:mm:ss z");
    df.setTimeZone(tz);
    final Date now = new Date();

    final String method = "GET";
    final String hostHeader = host;
    final String contentTypeHeader = "";
    final String md5Header = "";
    final String queryParams = "";
    final String dateHeader = df.format(now);
    final String url = "https://" + host + resourcePath;

    final StringJoiner joiner = new StringJoiner("\n");
    joiner.add(method).add(hostHeader).add(contentTypeHeader).add(md5Header);
    joiner.add(resourcePath).add(queryParams).add(dateHeader).add(secret);
    final String message = joiner.toString();

    final Mac hmac;
    try {
      hmac = Mac.getInstance("HmacSHA256");
    } catch (final NoSuchAlgorithmException e) {
      throw new DataConfigurationException(e);
    }
    final SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
    try {
      hmac.init(secretKeySpec);
    } catch (final InvalidKeyException e) {
      throw new DataConfigurationException(e);
    }
    final byte[] digest = hmac.doFinal(message.getBytes());
    final String signature = Base64.getEncoder().encodeToString(digest);

    final WebResource request = client.resource(url);
    final ClientResponse response = request
        .header("Authorization", "HMACAuth " + key + ":" + signature).header("Date", dateHeader)
        .get(ClientResponse.class);
    if (response.getStatus() != expectedStatus) {
      throw new UnexpectedApiResponseException(response.getStatus(), url);
    }
    return response;
  }

  public void downloadFile(final String url, final Path dest, final int expectedStatus)
      throws IOException, UnexpectedApiResponseException {
    Files.createDirectories(dest.getParent());

    int retries = 10;
    while (retries-- > 0) {
      try {
        final WebResource request = client.resource(url);
        final ClientResponse response = request.get(ClientResponse.class);
        if (response.getStatus() != expectedStatus) {
          throw new UnexpectedApiResponseException(response.getStatus(), url);
        }
        final File downloaded = response.getEntity(File.class);
        Files.move(downloaded.toPath(), dest, StandardCopyOption.REPLACE_EXISTING);
        try (final FileWriter out = new FileWriter(downloaded)) {
          out.flush();
        }
        return;
      } catch (final ClientHandlerException e) {
        System.err.println(e);
      }
    }
  }

}
