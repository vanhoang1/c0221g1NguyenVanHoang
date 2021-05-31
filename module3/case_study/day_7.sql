-- day 7
use case_study;
-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi
UPDATE dich_vu_di_kem 
SET 
    gia = gia * 2
WHERE
    id_dich_vu_di_kem IN (SELECT 
            ct.id_dich_vu_di_kem
        FROM
            hop_dong h
                JOIN
            chi_tiet_hop_dong ct ON h.id_hop_dong = ct.id_hop_dong
        WHERE
            YEAR(h.ngay_lam_hop_dong) = 2019
        GROUP BY ct.id_dich_vu_di_kem
        HAVING COUNT(ct.id_dich_vu_di_kem) > 10);
-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
SELECT 
    h.id_khach_hang 'id',
    h.ho_ten,
    email,
    sdt,
    ngay_sinh,
    dia_chi,
    1 as `type`
FROM
    khach_hang h 
UNION all SELECT 
    id_nhan_vien, ho_ten, email, sdt, ngay_sinh, dia_chi, 0 as `type`
FROM
    nhan_vien n;