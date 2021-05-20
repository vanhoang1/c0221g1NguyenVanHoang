-- p1
-- 1.	Đưa ra thông tin gồm mã số, họ tên và tên khoa của tất cả các giảng viên
SELECT 
    i.intructor_id, i.intructor_name, f.faculty_name
FROM
    intructor i
        JOIN
    faculty f ON i.faculty_id = f.faculty_id;
-- 2.	Đưa ra thông tin gồm mã số, họ tên và tên khoa của các giảng viên của khoa ‘DIA LY va QLTN’
SELECT 
    i.intructor_id, i.intructor_name, f.faculty_name
FROM
    intructor i
        JOIN
    faculty f ON i.faculty_id = f.faculty_id
WHERE
    f.faculty_name IN ('DIA LY' , 'DIA LY');
-- 3.	Cho biết số sinh viên của khoa ‘CONG NGHE SINH HOC’
SELECT 
    COUNT(s.student_id) 'so_hoc_sinh'
FROM
    student s
        JOIN
    faculty f ON f.faculty_id = s.faculty_id
WHERE
    f.faculty_name = 'CONG NGHE SINH HOC';
-- 4.	Đưa ra danh sách gồm mã số, họ tên và tuổi của các sinh viên khoa ‘TOAN’
SELECT 
    s.student_id,s.student_name, (year(now())-year(s.date_of_birth)) as 'tuoi'
FROM
    student s
        JOIN
    faculty f ON f.faculty_id = s.faculty_id
WHERE
    f.faculty_name = 'TOAN';
-- 5.	Cho biết số giảng viên của khoa ‘CONG NGHE SINH HOC’
SELECT 
   count(i.intructor_id) 'so_gian_vien'
FROM
    intructor i
        JOIN
    faculty f ON i.faculty_id = f.faculty_id
WHERE
    f.faculty_name ='CONG NGHE SINH HOC';
-- 6.	Cho biết thông tin về sinh viên không tham gia thực tập
SELECT 
    COUNT(s.student_id) 'so_hoc_sinh'
FROM
    student s
        LEFT JOIN
    intructor_student si ON si.student_id = s.student_id
WHERE
    si.student_id IS NULL;
-- 7.	Đưa ra mã khoa, tên khoa và số giảng viên của mỗi khoa
SELECT 
    i.faculty_id,
    f.faculty_name,
    COUNT(i.intructor_id) 'so_gian_vien'
FROM
    intructor i
        JOIN
    faculty f ON i.faculty_id = f.faculty_id
GROUP BY faculty_id;
-- 8.	Cho biết số điện thoại của khoa mà sinh viên có tên ‘Le van son’ đang theo học
SELECT 
 f.phone
FROM
    student s
        JOIN
    faculty f ON f.faculty_id = s.faculty_id
WHERE
    s.student_name = 'Le van son';
