drop schema if exists `internship`;
CREATE SCHEMA `internship` ;
use internship;
CREATE TABLE project (
    project_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    project_name CHAR(10) not NULL,
    exepense INT NULL,
    place_of_intern VARCHAR(45) NULL,
    PRIMARY KEY (project_id)
);
CREATE TABLE faculty (
    faculty_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    faculty_name CHAR(30) not NULL,
    phone CHAR(10) NULL,
    PRIMARY KEY (faculty_id)
);
CREATE TABLE intructor (
    intructor_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    intructor_name CHAR(30) not NULL,
    salary DECIMAL(5 , 2 ),
    faculty_id INT NOT NULL,
    PRIMARY KEY (intructor_id),
    CONSTRAINT fk_itr_fc FOREIGN KEY (faculty_id)
        REFERENCES faculty (faculty_id)
);
CREATE TABLE student (
    student_id INT NOT NULL UNIQUE AUTO_INCREMENT,
    student_name CHAR(40) NOT NULL,
    faculty_id INT NOT NULL,
    date_of_birth INT,
    place_of_birth DATE,
     PRIMARY KEY (student_id),
    CONSTRAINT fk_st_fc FOREIGN KEY (faculty_id)
        REFERENCES faculty (faculty_id)
);
CREATE TABLE intructor_student (
    student_id INT,
    project_id INT,
    intructor_id INT,
    grade DECIMAL(5 , 2 ),
    CONSTRAINT intructor_student_id PRIMARY KEY (student_id , project_id , intructor_id),
    CONSTRAINT fk_is_st FOREIGN KEY (student_id)
        REFERENCES student (student_id),
    CONSTRAINT fk_is_it FOREIGN KEY (intructor_id)
        REFERENCES intructor (intructor_id),
    CONSTRAINT fk_is_pj FOREIGN KEY (project_id)
        REFERENCES project (project_id)
);
INSERT INTO `internship`.`project` (`project_id`, `project_name`, `exepense`, `place_of_intern`) VALUES ('1', 'nhà lá', '100', 'sss');
INSERT INTO `internship`.`project` (`project_id`, `project_name`, `exepense`, `place_of_intern`) VALUES ('2', 'web', '200', 'ttt');
INSERT INTO `internship`.`project` (`project_id`, `project_name`, `exepense`, `place_of_intern`) VALUES ('3', 'vacin', '300', 'aaa');
INSERT INTO `internship`.`faculty` (`faculty_id`, `faculty_name`, `phone`) VALUES ('1', 'xay dung', '123');
INSERT INTO `internship`.`faculty` (`faculty_id`, `faculty_name`, `phone`) VALUES ('2', 'tin hoc', '456');
INSERT INTO `internship`.`faculty` (`faculty_id`, `faculty_name`, `phone`) VALUES ('3', 'duoc', '789');
INSERT INTO `internship`.`intructor` (`intructor_id`, `intructor_name`, `salary`, `faculty_id`) VALUES ('1', 'nam', '1', '1');
INSERT INTO `internship`.`intructor` (`intructor_id`, `intructor_name`, `salary`, `faculty_id`) VALUES ('2', 'vu', '2', '2');
INSERT INTO `internship`.`intructor` (`intructor_id`, `intructor_name`, `salary`, `faculty_id`) VALUES ('3', 'tung', '3', '3');
INSERT INTO `internship`.`student` (`student_name`, `faculty_id`, `date_of_birth`, `place_of_birth`) VALUES ('hieu', '1', '1995-1-1', 'qn');
INSERT INTO `internship`.`student` (`student_name`, `faculty_id`, `date_of_birth`, `place_of_birth`) VALUES ('hung', '2', '1997-3-3', 'vn');
INSERT INTO `internship`.`student` (`student_name`, `faculty_id`, `date_of_birth`, `place_of_birth`) VALUES ('trang', '3', '1989-5-5', 'tq');
INSERT INTO `internship`.`intructor_student` (`student_id`, `project_id`, `intructor_id`, `grade`) VALUES ('1', '1', '1', '12');
INSERT INTO `internship`.`intructor_student` (`student_id`, `project_id`, `intructor_id`, `grade`) VALUES ('3', '2', '1', '2');
INSERT INTO `internship`.`intructor_student` (`student_id`, `project_id`, `intructor_id`, `grade`) VALUES ('2', '3', '2', '4');
