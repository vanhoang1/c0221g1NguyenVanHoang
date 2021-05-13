drop schema if exists `student_management`;
CREATE SCHEMA if not exists `student_management` ;
use student_management ;
CREATE TABLE IF NOT EXISTS `student` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL,
    `age` INT NULL,
    `country` VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
);
create table teacher(
	`id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL,
    `age` INT NULL,
    `country` VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
);
create table class(
	`id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(45) NULL,
     PRIMARY KEY (`id`)
);
  
insert into student(`name`,`age`,`country`)
value ("hoang",22,"vietnam"),
("hoang",22,"vietnam"),
("hoang",22,"vietnam"),
("tam",44,"hanquoc"),
("minh",66,"vietnam");
SET SQL_SAFE_UPDATES = 0;
UPDATE student 
SET 
    `name` = 'trungso'
WHERE
    NOT `id` = 1 AND `age` = 22
        OR `country` = 'vietnam';
DELETE FROM student 
WHERE
    `id` = 2;
SELECT 
    *
FROM
    student
ORDER BY `name`;
  