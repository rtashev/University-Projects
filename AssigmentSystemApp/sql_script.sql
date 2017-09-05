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
<<<<<<< HEAD
`date_submitted` date,
=======
`date_released` date,
>>>>>>> ae71731f9f709b6e15081c2cf710941879ada396
`user_id` int,
`pdf` blob,
PRIMARY KEY (assigment_id),
CONSTRAINT FOREIGN KEY (user_id) REFERENCES users (user_id)
);
<<<<<<< HEAD

INSERT INTO assigments ( name, category, description, is_assigned, is_submitted)
   VALUES ( 'someAssigment', 'VR', 'dsrc', false, false); 
INSERT INTO assigments ( name, category, description, is_assigned, is_submitted)
   VALUES ( 'someAssigment2', 'AI', 'dsrc1', false, false); 
INSERT INTO assigments ( name, category, description, is_assigned, is_submitted)
   VALUES ( 'someAssigment3', 'CG', 'dsrc2', false, false); 
INSERT INTO assigments ( name, category, description, is_assigned, is_submitted)
   VALUES ( 'someAssi', 'VR', 'dsrc2', true, false); 

select * from users;

select * from assigments;

INSERT INTO users ( name, password, first_name, last_name, role, has_assigment )
   VALUES ( 'user1', 'user1', 'Ivan', 'Ivanov', 'STUDENT', FALSE);
   
INSERT INTO users ( name, password, first_name, last_name, role, has_assigment )
   VALUES ( 'user2', 'user2', 'Petar', 'Petrov', 'STUDENT', TRUE);


=======
>>>>>>> ae71731f9f709b6e15081c2cf710941879ada396
