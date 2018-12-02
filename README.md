# ImageGallery
Simple Image Gallery maven project using jsp and Servlet to store the images in sql database(BLOB) and using the pagination to limit the amount of results fetched from database

Tomcat - 9.0
Connector MySQL- 8.0.12

MySQL username - root
MySQL password - mysqlpass
Database Name - imageGallery

Tables Required :

Table name - USERS
----------+--------------+------+-----+---------+----------------+
| Field    | Type         | Null | Key | Default | Extra          |
+----------+--------------+------+-----+---------+----------------+
| id       | int(11)      | NO   | PRI | NULL    | auto_increment |
| username | varchar(255) | NO   | PRI | NULL    |                |
| password | varchar(255) | YES  |     | NULL    |              

Table name - GALLERY

+----------+--------------+------+-----+---------+----------------+
| Field    | Type         | Null | Key | Default | Extra          |
+----------+--------------+------+-----+---------+----------------+
| ID       | int(11)      | NO   | PRI | NULL    | auto_increment |
| USERNAME | varchar(255) | NO   |     | NULL    |                |
| TITLE    | varchar(255) | NO   |     | NULL    |                |
| CAPTION  | varchar(255) | NO   |     | NULL    |                |
| IMAGE    | mediumblob   | NO   |     | NULL    |                |
+----------+--------------+------+-----+---------+----------------+
