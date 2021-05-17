-- day 4
use case_study;
-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).
SELECT 
    h.id_hop_dong,h.ngay_lam_hop_dong,h.ngay_ket_thuc,h.tien_dat_coc,COUNT(ct.id_chi_tiet_hop_dong) as 'SoLuongDichVuDiKem'
FROM
    hop_dong h
        JOIN
    chi_tiet_hop_dong ct ON h.id_hop_dong = ct.id_hop_dong
      GROUP BY ct.id_hop_dong;
-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
SELECT 
 dvdk.*
FROM
    khach_hang k
        JOIN
    hop_dong h ON k.id_khach_hang = h.id_khach_hang
        JOIN
    chi_tiet_hop_dong ct ON h.id_hop_dong = ct.id_hop_dong
        JOIN
    dich_vu_di_kem dvdk ON ct.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
WHERE
    k.id_khach_hang in  (SELECT 
            k1.id_khach_hang
        FROM
            khach_hang k1
                JOIN
            loai_khach lk
        WHERE
            lk.id_loai_khach = 1
                AND k1.dia_chi IN ('Vinh' , 'Quảng Ngãi'));
-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.


SELECT 
	h.id_hop_dong,
	nv.ho_ten 'ten_nhan_vien',
    k.ho_ten 'ten_khach_hang',
    k.sdt,
    COUNT(ct.id_chi_tiet_hop_dong) as 'SoLuongDichVuDiKem'
    
FROM
    khach_hang k
        JOIN
    hop_dong h ON k.id_khach_hang = h.id_khach_hang 
    join nhan_vien nv on h.id_nhan_vien= nv.id_nhan_vien
    join chi_tiet_hop_dong ct on ct.id_hop_dong =h.id_hop_dong
    join dich_vu_di_kem dvdk on dvdk.id_dich_vu_di_kem= ct.id_dich_vu_di_kem 
    
WHERE
    (h.ngay_lam_hop_dong BETWEEN '2019-10-1' AND '2019-12-31')
        AND h.id_khach_hang NOT IN (SELECT 
            h.id_khach_hang
        FROM
            hop_dong h 
        WHERE
            h.ngay_lam_hop_dong BETWEEN '2020-01-1' AND '2020-6-30')
GROUP BY ct.id_hop_dong;
