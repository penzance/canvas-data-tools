package edu.harvard.canvas_data.analysis;

import java.awt.Color;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import edu.harvard.data.client.DataSetReader;
import edu.harvard.data.client.DataTable;
import edu.harvard.data.client.canvas.tables.CanvasTable;
import wordcloud.CollisionMode;
import wordcloud.WordCloud;
import wordcloud.WordFrequency;
import wordcloud.bg.CircleBackground;
import wordcloud.font.scale.SqrtFontScalar;
import wordcloud.nlp.FrequencyAnalyzer;
import wordcloud.nlp.normalize.LowerCaseNormalizer;
import wordcloud.palette.ColorPalette;

public class WordCloudGenerator {

  public void generateCloud(final DataSetReader data, final String tableName, final String field,
      final Path output, final int wordCount) throws IOException {
    final FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
    frequencyAnalyzer.setWordFrequencesToReturn(wordCount);
    frequencyAnalyzer.setMinWordLength(4);
    frequencyAnalyzer.addNormalizer(new LowerCaseNormalizer());
    final List<WordFrequency> wordFrequencies = frequencyAnalyzer
        .load(getStrings(data, tableName, field));

    final WordCloud wordCloud = new WordCloud(600, 600, CollisionMode.PIXEL_PERFECT);
    wordCloud.setPadding(2);
    wordCloud.setBackground(new CircleBackground(300));
    wordCloud.setColorPalette(new ColorPalette(new Color(0x4055F1), new Color(0x408DF1),
        new Color(0x40AAF1), new Color(0x40C5F1), new Color(0x40D3F1), new Color(0xFFFFFF)));
    wordCloud.setFontScalar(new SqrtFontScalar(10, 40));
    wordCloud.build(wordFrequencies);
    wordCloud.writeToFile(output.toString());
  }

  private List<String> getStrings(final DataSetReader reader, final String tableName,
      final String field) {
    if (!reader.getTables().containsKey(tableName)) {
      throw new IllegalArgumentException(tableName + " is not a table in the data set");
    }
    final Class<? extends DataTable> cls = CanvasTable.fromSourceName(tableName).getTableClass();
    final List<String> strings = new ArrayList<String>();
    try {
      final Method mthd = cls.getMethod(getMethodName(field));
      for (final DataTable row : reader.getTable(tableName, cls)) {
        final String str = (String) mthd.invoke(row);
        if (str != null) {
          strings.add(str);
        }
      }
    } catch (SecurityException | IllegalAccessException | IllegalArgumentException
        | InvocationTargetException e) {
      throw new RuntimeException(e);
    } catch (final NoSuchMethodException e) {
      throw new IllegalArgumentException(field + " is not a field in " + tableName);
    }
    return strings;
  }

  private String getMethodName(final String field) {
    String mthd = "get";
    for (final String part : field.split("_")) {
      mthd += part.substring(0, 1).toUpperCase() + part.substring(1);
    }
    return mthd;
  }
}
