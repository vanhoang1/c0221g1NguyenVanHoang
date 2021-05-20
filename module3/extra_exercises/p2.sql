-- 1.	Cho biết mã số và tên của các đề tài do giảng viên ‘Tran son’ hướng dẫn
SELECT 
    p.project_id,p.project_name
FROM
    intructor i
        JOIN
    intructor_student si ON i.intructor_id = si.intructor_id
        JOIN
    project p ON p.project_id = si.project_id
where
	i.intructor_name= 'Tran son';
-- 2.	Cho biết tên đề tài không có sinh viên nào thực tập
SELECT 
    p.project_name
FROM
    project p
        LEFT JOIN
    intructor_student si ON p.project_id = si.project_id
        LEFT JOIN
    student s ON s.student_id = si.student_id
WHERE
    si.project_id IS NULL;
-- 3.	Cho biết mã số, họ tên, tên khoa của các giảng viên hướng dẫn từ 3 sinh viên trở lên.
SELECT 
    si.intructor_id, i.intructor_name, f.faculty_name
FROM
    intructor i
        JOIN
    intructor_student si ON i.intructor_id = si.intructor_id
        JOIN
    faculty f ON f.faculty_id = i.faculty_id
GROUP BY si.intructor_id
HAVING COUNT(si.student_id) >= 3;
-- 4.	Cho biết mã số, tên đề tài của đề tài có kinh phí cao nhất
SELECT 
    project_id, project_name
FROM
    project
WHERE
    exepense = (SELECT 
            MAX(exepense)
        FROM
            project);
-- 5.	Cho biết mã số và tên các đề tài có nhiều hơn 2 sinh viên tham gia thực tập;

SELECT 
    si.project_id, p.project_name
FROM
    project p
        JOIN
    intructor_student si ON p.project_id = si.project_id
GROUP BY si.project_id
HAVING COUNT(si.student_id) > 2;
-- 6.	Đưa ra mã số, họ tên và điểm của các sinh viên khoa ‘DIALY và QLTN’
SELECT 
    s.student_id, s.student_name, si.grade
FROM
    student s
        LEFT JOIN
    intructor_student si ON s.student_id = si.student_id
        LEFT JOIN
    faculty f ON s.faculty_id = f.faculty_id
WHERE
    f.faculty_name in('DIALY','QLTN');
-- 7.	Đưa ra tên khoa, số lượng sinh viên của mỗi khoa
	SELECT 
    f.faculty_name, COUNT(s.student_id) 'so_luong_sv'
FROM
    student s
        JOIN
    faculty f ON s.faculty_id = f.faculty_id
GROUP BY s.faculty_id;
-- 8.	Cho biết thông tin về các sinh viên thực tập tại quê nhà
SELECT 
    s.*
FROM
    student s
        JOIN
    intructor_student si ON s.student_id = si.student_id
        JOIN
    project p ON p.project_id = si.project_id
WHERE
    p.place_of_intern = s.place_of_birth;
-- 9.	Hãy cho biết thông tin về những sinh viên chưa có điểm thực tập
SELECT 
    s.*
FROM
    student s
        LEFT JOIN
    intructor_student si ON s.student_id = si.student_id
WHERE
    si.grade IS NULL;
    
-- 10. Đưa ra danh sách gồm mã số, họ tên các sinh viên có điểm thực tập bằng 0
	
SELECT DISTINCT
    s.student_id, s.student_name
FROM
    student s
        JOIN
    intructor_student si ON s.student_id = si.student_id
WHERE
    si.grade = 0;