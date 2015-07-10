# sudo pip install pyopenssl ndg-httpsclient
# sudo pip install psycopg2
# python dump_requests.py

import csv
import datetime
import psycopg2

import secure

# Set start_date and end_date to define the range of days' requests to download. Each will be stored in a separate file.
start_date = datetime.date(2015, 7, 8)
end_date = datetime.date.today()

delta = datetime.timedelta(days=1)
current_date = start_date

conn = psycopg2.connect("dbname='{}' user='{}' host='{}' port={} password='{}'".format(
    secure.DBNAME, secure.USER, secure.HOST, secure.PORT, secure.PASSWORD
))

while current_date <= end_date:
   day = current_date.strftime("%d")
   month = current_date.strftime("%m")
   year = current_date.strftime("%Y")
   filename = "requests-{}-{}-{}.csv".format(year, month, day)
   print "Creating {}".format(filename)

   cur = conn.cursor()
   cur.execute('select * from requests where datepart(day, timestamp)={} and datepart(month, timestamp)={} and datepart(year, timestamp)={}'.format(day, month, year))
   with open(filename, 'wb') as csvfile:
       writer = csv.writer(csvfile, delimiter=',',quotechar='"', quoting=csv.QUOTE_ALL)
       writer.writerow([desc[0] for desc in cur.description])
       rows = cur.fetchall()
       for row in rows:
           writer.writerow(row)
       current_date += delta
        
