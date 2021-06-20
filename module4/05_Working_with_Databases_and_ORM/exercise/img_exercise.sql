drop schema if exists img_of_the_day;
create schema img_of_the_day;
use img_of_the_day;
create table poll(
id int auto_increment,
evaluate int,
author varchar(45),
feedback varchar(45),
 count_like int,
 date_created date,
 
primary key (id)
);
INSERT INTO `img_of_the_day`.`poll` (`evaluate`, `author`, `feedback`,count_like,date_created) VALUES ('1', 'abc', 'aaaaaa',123,current_date());
INSERT INTO `img_of_the_day`.`poll` (`evaluate`, `author`, `feedback`,count_like,date_created) VALUES ('2', 'xyz', 'zzzzzz',456,current_date());

