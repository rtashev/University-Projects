CREATE TABLE `users`
(
`user_id` int NOT NULL AUTO_INCREMENT,
`name` varchar(30) NOT NULL,
`password` varchar(100) NOT NULL,
`first_name` varchar(30) NOT NULL,
`last_name` varchar(30) NOT NULL,
`role` varchar(30),
`has_assigment` boolean,
primary key (user_id)
);

CREATE TABLE `assigments`
(
`assigment_id` int NOT NULL auto_increment,
`name` varchar(50) NOT NULL,
`category` varchar(2) NOT NULL,
`description` varchar(600) NOT NULL,
`is_assigned` boolean,
`is_submitted` boolean,
`date_released` date,
`user_id` int,
`pdf` blob,
PRIMARY KEY (assigment_id),
CONSTRAINT FOREIGN KEY (user_id) REFERENCES users (user_id)
);
