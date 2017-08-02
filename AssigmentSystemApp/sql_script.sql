CREATE TABLE users
(
user_id int NOT NULL AUTO_INCREMENT,
name varchar(30) NOT NULL,
password varchar(100) NOT NULL,
first_name varchar(30) NOT NULL,
last_name varchar(30) NOT NULL,
role varchar(30),
enabled boolean,
primary key (user_id)
);