use quan_ly_sinh_vien;
select *
from `subject`
where credit=(select max(credit) from subject )
