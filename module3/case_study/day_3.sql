-- DAY 3
use case_study;
-- 
-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).
select * from  hop_dong;
select * from dich_vu;
SELECT 
    d.id_dich_vu,
    d.ten_dich_vu,
    d.dien_tich,
    d.chi_phi_thue,
    ld.ten_loai_dich_vu,
    h.ngay_lam_hop_dong
FROM
    dich_vu d
        LEFT JOIN
    hop_dong h ON h.id_dich_vu = d.id_dich_vu
        LEFT JOIN
    loai_dich_vu ld ON d.id_loai_dich_vu = ld.id_loai_dich_vu
WHERE
    d.id_dich_vu NOT IN (SELECT 
            h.id_dich_vu
        FROM
            hop_dong h
        WHERE
            h.ngay_lam_hop_dong BETWEEN '2019-1-1' AND '2019-3-31')
	group by h.id_dich_vu;
-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng được Khách hàng đặt phòng  trong năm 2019.
SELECT 
    d.id_dich_vu,
    d.ten_dich_vu,
    d.dien_tich,
    d.so_nguoi_toi_da,
    d.chi_phi_thue,
    ld.ten_loai_dich_vu
FROM
    dich_vu d
        JOIN
    hop_dong h ON h.id_dich_vu = d.id_dich_vu
        JOIN
    loai_dich_vu ld ON d.id_loai_dich_vu = ld.id_loai_dich_vu
WHERE
    YEAR(h.ngay_lam_hop_dong) = '2018'
        AND h.id_khach_hang NOT IN (SELECT 
            h.id_khach_hang
        FROM
            dich_vu d
                JOIN
            hop_dong h ON h.id_dich_vu = d.id_dich_vu
        WHERE
            YEAR(h.ngay_lam_hop_dong) = '2019');
-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoTenKhachHang không trùng nhau.
-- cách 1:
SELECT DISTINCT
    ho_ten
FROM
    khach_hang;
-- cách 2:
SELECT 
    ho_ten
FROM
    khach_hang
GROUP BY ho_ten;
-- cách 3:
SELECT 
    a.ho_ten, b.ho_ten
FROM
    khach_hang a
        LEFT JOIN
    khach_hang b ON a.ho_ten = b.ho_ten
        AND a.id_khach_hang > b.id_khach_hang
WHERE
    b.ho_ten IS NULL;
-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
SELECT 
    YEAR(h.ngay_lam_hop_dong),
    MONTH(h.ngay_lam_hop_dong),
    SUM(d.chi_phi_thue + ct.so_luong * dvdk.gia) AS 'tong_tien'
FROM
    hop_dong h
        JOIN
    dich_vu d ON h.id_dich_vu = d.id_dich_vu
        JOIN
    chi_tiet_hop_dong ct ON h.id_hop_dong = ct.id_hop_dong
        JOIN
    dich_vu_di_kem dvdk ON ct.id_dich_vu_di_kem = ct.id_dich_vu_di_kem
GROUP BY MONTH(h.ngay_lam_hop_dong) , YEAR(h.ngay_lam_hop_dong)
ORDER BY YEAR(h.ngay_lam_hop_dong) , MONTH(h.ngay_lam_hop_dong);


