drop schema if exists `student-management`;
CREATE SCHEMA if not exists `student-management` ;
use `student-management`;
CREATE TABLE if not exists `student-management`.`student-management` (
  `id` INT NOT NULL auto_increment,
  `name` VARCHAR(45) NULL,
  `age` INT NULL,
  `country` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
	insert into `student-management`.`student-management`(`name`,`age`,`country`)
  value ("hoang",22,"vietnam"),
("hoang",22,"vietnam"),
("hoang",22,"vietnam"),
("tam",44,"hanquoc"),
("minh",66,"vietnam");
SET SQL_SAFE_UPDATES = 0;
UPDATE `student-management`.`student-management` 
SET 
    `name` = 'trungso'
WHERE
  not  `id` = 1 and `age`=22 or `country`='vietnam';
DELETE FROM `student-management` 
WHERE
    `id` = 2 ;
  SELECT 
    *
FROM
    `student-management`.`student-management`
    order by `name`;
  