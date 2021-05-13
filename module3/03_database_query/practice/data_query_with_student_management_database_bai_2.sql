use quan_ly_sinh_vien;
select * from student;
select* from student where `status`= true;
SELECT *
FROM `subject`
WHERE credit < 10;
SELECT s.student_id, s.student_name, c.class_name
FROM student s join class c on s.class_id = c.class_id;