require 'json'

filename = ARGV[0]
puts "Processing: #{filename}"

bad_routes = []

File.open("#{filename}.paths", 'w') do |f|
  File.open("#{filename}.errors", 'w') do |errors|
    CSV.foreach(filename) do |request|
      url = request[11]
      verb = request[16]
      begin
        route_info = Rails.application.routes.recognize_path url, method: verb
        f.write "#{request[0]},#{JSON.dump(route_info)}\n"
      rescue ActionController::RoutingError
        bad_routes << request
      rescue => e
        bad_routes << request
        errors.write "Error processings #{verb} #{url}"
        errors.write e.message
        errors.write e.backtrace.join("\n")
        errors.write "\n\n"
      end
    end
  end
end

File.open("#{filename}.bad_routes", 'w') do |f|
  bad_routes.each do |bad_route|
    f.write "#{bad_route[16]} #{bad_route[11]}\n"
  end
end
puts "Done with #{filename}"
