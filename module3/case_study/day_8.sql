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
    and( idnv in (select id_nhan_vien from nhan_vien) )
    and (idkh in (select id_khach_hang from khach_hang) )
    and (iddv in (select id_dich_vu from dich_vu))) then 
    insert into hop_dong(id_hop_dong,id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong) 
    value (id,idnv,idkh,iddv,date(now()));
    else SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Chưa thêm được';
    end if;
end;
// delimiter ;
call sp_2(1111,1,1,1);
-- 25.	Tạo triggers có tên Tr_1 Xóa bản ghi trong bảng HopDong thì hiển thị tổng số lượng bản ghi còn lại có trong bảng HopDong ra giao diện console của database.
delimiter //
create trigger tr_1 after delete on hop_dong 
for each row 
begin
declare a int;
declare b varchar(45);
set a = (select count(id_hop_dong) from hop_dong );
set b =concat( 'tổng số lượng bản ghi còn lại : ' , a);
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = b ;
end ;
// delimiter ;
delete from hop_dong  where id_hop_dong=1;
-- 26.	Tạo triggers có tên Tr_2 Khi cập nhật Ngày kết thúc hợp đồng, cần kiểm tra xem thời gian cập nhật có phù hợp hay không, với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. Nếu dữ liệu hợp lệ thì cho phép cập nhật

delimiter //
create trigger tr_2 before update on hop_dong 
for each row 
begin
declare a date;
declare b date;
set a = new.ngay_lam_hop_dong;
set b = new.ngay_ket_thuc;
if(datediff(b,a)<2) then
SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày';
end if;
end ;
// delimiter ;
update hop_dong set ngay_lam_hop_dong ='2057-1-1' , ngay_ket_thuc='2007-1-1';
-- 27.	Tạo user function thực hiện yêu cầu sau:
-- a.	Tạo user function func_1: Đếm các dịch vụ đã được sử dụng với Tổng tiền là > 2.000.000 VNĐ.
delimiter //
create function func_1()
returns int
deterministic
begin
declare f_dem int;
set	f_dem = (
select count(id) from (SELECT 
                h.id_dich_vu AS id 
            FROM
                hop_dong h
            JOIN dich_vu d ON h.id_dich_vu = d.id_dich_vu
            JOIN chi_tiet_hop_dong ct ON ct.id_hop_dong = h.id_hop_dong
            JOIN dich_vu_di_kem dvdk ON dvdk.id_dich_vu_di_kem = ct.id_dich_vu_di_kem
            GROUP BY h.id_dich_vu
            HAVING SUM(d.chi_phi_thue + ct.so_luong *  COALESCE( dvdk.gia, 0)) > 2000000 ) as t
);
return (f_dem);
end;
// delimiter ;
select func_1() as 'dem_dich_vu' ; 
-- b.	Tạo user function Func_2: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp đồng mà Khách hàng đã thực hiện thuê dịch vụ (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng). Mã của Khách hàng được truyền vào như là 1 tham số của function này.
 delimiter //
create function func_2(f_id int)
returns int
deterministic
begin
declare f_dem int;
set	f_dem = (
SELECT 
    MAX(DATEDIFF(h.ngay_ket_thuc, h.ngay_lam_hop_dong))
FROM
    chi_tiet_hop_dong ct
        RIGHT JOIN
    hop_dong h ON ct.id_hop_dong = h.id_hop_dong
WHERE
    ct.id_hop_dong IS NOT NULL
        AND h.id_khach_hang = f_id
);
return (f_dem);
end;
// delimiter ;
 select func_2(1) as 'so_ngay';
-- 28.	Tạo Store procedure Sp_3 để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” từ đầu năm 2015 đến hết năm 2019 
-- để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong bảng DichVu)
-- và xóa những HopDong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng HopDong) và những bản liên quan khác
delimiter //
create procedure p_del_room ()
begin
delete from dich_vu where id_dich_vu in (
select id from (
	SELECT 
    h.id_dich_vu 'id'
FROM
    hop_dong h
        JOIN
    dich_vu d ON d.id_dich_vu = h.id_dich_vu
        JOIN
    loai_dich_vu ldv  ON  ldv. id_loai_dich_vu = d.id_loai_dich_vu
WHERE
    ldv.ten_loai_dich_vu = 'Room'
        AND YEAR(h.ngay_lam_hop_dong) BETWEEN 2015 AND 2019) as t);
end;
//delimiter ;

drop procedure p_del_room;
call  p_del_room ;