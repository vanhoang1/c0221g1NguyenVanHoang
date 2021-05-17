use quan_ly_sinh_vien;
-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
SELECT 
    *
FROM
    student
WHERE
    student_name LIKE 'h%';
-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12. 
SELECT 
    *
FROM
    class
WHERE
    MONTH(start_date) = 12;
-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
SELECT 
    *
FROM
    `subject`
WHERE
    credit >= 3 AND credit <= 5;
-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
set SQL_SAFE_UPDATES=0;
UPDATE student 
SET 
    class_id = '2'
WHERE
    student_name = 'Hung';
-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
SELECT 
    stu.student_name, sub.sub_name, m.mark
FROM
    student stu
        JOIN
    mark m ON stu.student_id = m.student_id
        JOIN
    `subject` sub ON m.sub_id = sub.sub_id
    order by m.mark asc, stu.student_name desc
;

