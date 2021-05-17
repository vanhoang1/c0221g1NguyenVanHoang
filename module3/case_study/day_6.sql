-- day 6
use case_study;
-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
-- xóa cả nhưng người chưa làm hợp đồng nào
-- DELETE FROM nhan_vien 
-- WHERE
--     (id_nhan_vien IN (SELECT DISTINCT
--         id
--     FROM
--         (SELECT 
--             nv.id_nhan_vien AS id
--         FROM
--             hop_dong h
--         RIGHT JOIN nhan_vien nv ON h.id_nhan_vien = nv.id_nhan_vien
--         
--         WHERE
--             (YEAR(h.ngay_lam_hop_dong) BETWEEN 2017 AND 2019)
--             OR h.ngay_lam_hop_dong IS NULL
--         GROUP BY nv.id_nhan_vien
--         HAVING COUNT(h.id_hop_dong) = 0) AS a))
-- chỉ xóa những người có hợp đồng 
 DELETE FROM nhan_vien 
WHERE
    (id_nhan_vien IN (SELECT DISTINCT
        id
    FROM
        (SELECT 
            h.id_nhan_vien AS id
        FROM
            hop_dong h
        WHERE
            (YEAR(h.ngay_lam_hop_dong) BETWEEN 2017 AND 2019)
        GROUP BY h.id_nhan_vien
        HAVING COUNT(h.id_hop_dong) = 0) AS a));
-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ.
UPDATE khach_hang 
SET 
    id_loai_khach = 1
WHERE
    id_khach_hang IN (SELECT 
            id
        FROM
            (SELECT 
                h.id_khach_hang AS id , COALESCE( dvdk.gia, 0) as gia
            FROM
                hop_dong h
            JOIN dich_vu d ON h.id_dich_vu = d.id_dich_vu
            JOIN chi_tiet_hop_dong ct ON ct.id_hop_dong = h.id_hop_dong
            JOIN dich_vu_di_kem dvdk ON dvdk.id_dich_vu_di_kem = ct.id_dich_vu_di_kem
            WHERE
                YEAR(h.ngay_lam_hop_dong) = 2019
            GROUP BY h.id_khach_hang
            HAVING SUM(d.chi_phi_thue + ct.so_luong * gia) > 5000) AS t);
-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràngbuộc giữa các bảng).

