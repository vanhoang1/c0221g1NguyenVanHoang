-- day 8
use case_study; 
-- 21.	Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019”
CREATE VIEW v_nhan_vien AS
    SELECT 
        nv.*
    FROM
        nhan_vien nv
            JOIN
        hop_dong h ON nv.id_nhan_vien = h.id_nhan_vien
    WHERE
        nv.dia_chi = 'Hải Châu'
            AND h.ngay_lam_hop_dong = '2019-12-12';
select * from v_nhan_vien;
-- 22.	Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.
 SET SQL_SAFE_UPDATES = 0;
update v_nhan_vien set  dia_chi='Liên Chiểu';
-- 23.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với Id Khách hàng được truyền vào như là 1 tham số của Sp_1
delimiter //
create procedure sp_1 (in `id` int) 
begin
	delete from khach_hang where khach_hang.id_khach_hang=`id`;
end;
// delimiter ;
call sp_1(1);
-- 24.	Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.alter

delimiter //
create procedure sp_2(in `id` int , in `idnv` int, in `idkh` int, in `iddv` int )
begin
	if ((`id` not in (select id_hop_dong from hop_dong )) 
    and( idnv in (select id_nhan_vien from nhan_vien) ) and (idkh in (select id_khach_hang from khach_hang) ) and (iddv in (select id_dich_vu from dich_vu))) then 
    insert into hop_dong(id_hop_dong,id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong) 
    value (id,idnv,idkh,iddv,date(now()));
    else SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Chưa thêm được';
    end if;
end;
// delimiter ;
drop procedure if exists sp_2;
call sp_2(1111,1,1,1);
-- 25.	Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị tổng số lượng bản ghi còn lại có trong bảng HopDong ra giao diện console của database
create view dem as select count(h.id_hop_dong) from hop_dong h group by h.id_hop_dong;

delimiter //

//
create trigger tr_1 after delete on hop_dong 
for each row 
begin

end 
// delimiter ;
drop trigger tr_1 ;
delete from hop_dong where id_hop_dong =1;

