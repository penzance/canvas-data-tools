These scripts download data from the Canvas hosted Redshift database to a local file store. The functionality is split over two scripts: one that downloads the very large requests table; and one that downloads all other tables.

To use the script, you must first create a new file named 'secure.py' containing your credentials. Follow the example in sample-secure.py, and make sure that the file is readable only by the script.

The scripts depend on some non-standard Python libraries. They can be installed using:
    sudo pip install pyopenssl ndg-httpsclient
    sudo pip install psycopg2
or through the dependency management system of your choice.

The dump_all_but_requests.py script creates a new CSV file for every table listed in the 'tables' variable.

The dump_requests.py script creates a new CSV file for every day's worth of data from the requests table. You can specify a date range by modifying the 'start_date' and 'end_date' variables.