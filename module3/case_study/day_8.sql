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
//
call sp_1(1);
-- 24.	Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.

delimiter //
create procedure sp_2()

