use quan_ly_sinh_vien;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select *
from `subject`
where credit=(select max(credit) from subject );
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select sub.* from student stu join mark m on m.student_id = stu.student_id join subject sub on sub.sub_id=m.sub_id
where m.mark=(select max(mark) from mark);
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select s.* , avg(m.mark) as 'diem_trung_binh'
from student s join mark m  on s.student_id= m.student_id group by m.student_id 
order by  diem_trung_binh asc
