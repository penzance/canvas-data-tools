require 'json'

Dir.foreach('/mnt/data/data/') do |filename|
  next unless filename =~ /\Arequests.*\.csv\z/
  puts "Processing: #{filename}"

  requests = CSV.read("/mnt/data/data/#{filename}")
  bad_routes = []
  File.open("/mnt/data/data/#{filename}.paths", 'w') do |f|
    requests.each do |request|
      url = request[11]
      verb = request[16]
      begin
        route_info = Rails.application.routes.recognize_path url, method: verb
        f.write "#{request[0]},#{JSON.dump(route_info)}\n"
      rescue
        bad_routes << request
      end
    end
  end

  File.open("/mnt/data/data/#{filename}.bad_routes", 'w') do |f|
    bad_routes.each do |bad_route|
      f.write "#{bad_route[16]} #{bad_route[11]}\n"
    end
  end
end
