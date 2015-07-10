# sudo pip install pyopenssl ndg-httpsclient
# sudo pip install psycopg2
# python dump_all_but_requests.py

import psycopg2
import csv

import secure

tables = [
    'information_schema.columns',
    'information_schema.tables',
    'account_dim',
    'assignment_dim',
    'assignment_fact',
    'conversation_dim',
    'conversation_message_dim',
    'conversation_message_participant_fact',
    'course_dim',
    'course_section_dim',
    'date_dim',
    'discussion_entry_dim',
    'discussion_entry_fact',
    'discussion_topic_dim',
    'discussion_topic_fact',
    'enrollment_dim',
    'enrollment_fact',
    'enrollment_term_dim',
    'external_tool_activation_dim',
    'external_tool_activation_fact',
    'pseudonym_dim',
    'pseudonym_fact',
    'quiz_dim',
    'quiz_submission_fact',
    'role_dim',
    'submission_comment_dim',
    'submission_comment_fact',
    'submission_comment_participant_dim',
    'submission_comment_participant_fact',
    'submission_dim',
    'submission_fact',
    'user_dim',
]

conn = psycopg2.connect("dbname='{}' user='{}' host='{}' port={} password='{}'".format(
    secure.DBNAME, secure.USER, secure.HOST, secure.PORT, secure.PASSWORD
))

for table in tables:
    cur = conn.cursor()
    cur.execute('SELECT COUNT(*) FROM {}'.format(table))
    rows = cur.fetchmany(1000)
    for row in rows:
        print "{}: {}".format(table, row[0])
    all_rows = conn.cursor(table)
    all_rows.execute('SELECT * FROM {}'.format(table))
    with open('{}.csv'.format(table), 'wb') as csvfile:
        writer = csv.writer(csvfile, delimiter=',',quotechar='"', quoting=csv.QUOTE_ALL)
        columns = [desc[0] for desc in cur.description]
        writer.writerow(columns)
        rows = all_rows.fetchmany(1000)
        while rows:
            for row in rows:
                writer.writerow(row)
            rows = all_rows.fetchmany(1000)
    all_rows.close()
