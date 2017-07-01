CREATE TABLE users
(
user_id int NOT NULL AUTO_INCREMENT,
name varchar(30) NOT NULL,
password varchar(100) NOT NULL,
role varchar(30),
enabled boolean,
primary key (user_id)
);

CREATE TABLE books
(
book_id int NOT NULL AUTO_INCREMENT,
name varchar(30) NOT NULL,
isbn varchar(30) NOT NULL unique,
author varchar(50) NOT NULL,
date_released date NOT NULL,
published_by varchar(30) NOT NULL,
primary key (book_id)
);


CREATE TABLE books_lent
(
lent_id int NOT NULL AUTO_INCREMENT,
user_id int NOT NULL,
book_id int NOT NULL,
lent_from date NOT NULL,
lent_until date NOT NULL,
primary key (lent_id),
foreign key (user_id) references users(user_id),
foreign key (book_id) references books(book_id)
);

INSERT INTO users(name,password,role,enabled)
VALUES ('user1','password1','ROLE_USER',1);

INSERT INTO users(name,password,role,enabled)
VALUES ('admin1','admin1','ROLE_ADMIN',1);

SET SQL_SAFE_UPDATES=0;

delete from users
where role = 'ROLE_USER';

SELECT * FROM users;