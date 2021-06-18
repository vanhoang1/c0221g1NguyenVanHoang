drop schema if exists cms;
create schema cms;
use cms;
create table customer(
	id int auto_increment,
    name varchar(45) ,
    email varchar(45) ,
    address varchar(45),
    primary key(id)    
);
INSERT INTO `cms`.`customer` (`name`, `email`, `address`) VALUES ('abc', 'abc@gmail.com', 'aaa');
INSERT INTO `cms`.`customer` (`name`, `email`, `address`) VALUES ('xyz', 'xyz@gmail.com', 'xxxx');
