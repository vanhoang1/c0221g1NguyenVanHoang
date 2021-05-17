-- day 5
-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).

SELECT 
    *
FROM
    dich_vu_di_kem
WHERE
    id_dich_vu_di_kem in (SELECT 
            id
        FROM
            (SELECT 
                ct.id_dich_vu_di_kem AS id, COUNT(ct.id_dich_vu_di_kem) dem
            FROM
                hop_dong h
            JOIN chi_tiet_hop_dong ct ON ct.id_hop_dong = h.id_hop_dong
            JOIN dich_vu_di_kem dvdk ON dvdk.id_dich_vu_di_kem = ct.id_dich_vu_di_kem
            GROUP BY ct.id_dich_vu_di_kem) AS t
        WHERE
            t.dem = (SELECT 
                    MAX(dem)
                FROM
                    (SELECT 
                        ct.id_dich_vu_di_kem AS id, COUNT(ct.id_dich_vu_di_kem) dem
                    FROM
                        hop_dong h
                    JOIN chi_tiet_hop_dong ct ON ct.id_hop_dong = h.id_hop_dong
                    JOIN dich_vu_di_kem dvdk ON dvdk.id_dich_vu_di_kem = ct.id_dich_vu_di_kem
                    GROUP BY ct.id_dich_vu_di_kem) AS t));
                    
-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung.
SELECT 
    h.id_hop_dong,
    dvdk.ten_dich_vu_di_kem,
    ld.ten_loai_dich_vu,
    COUNT(ct.id_dich_vu_di_kem) 'so_lan_su_dung'
FROM
    hop_dong h
        JOIN
    chi_tiet_hop_dong ct ON ct.id_hop_dong = h.id_hop_dong
        JOIN
    dich_vu_di_kem dvdk ON dvdk.id_dich_vu_di_kem = ct.id_dich_vu_di_kem
        JOIN
    dich_vu d ON d.id_dich_vu = h.id_dich_vu
        JOIN
    loai_dich_vu ld ON d.id_loai_dich_vu = ld.id_loai_dich_vu
GROUP BY ct.id_dich_vu_di_kem
HAVING so_lan_su_dung = 1;
    
-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.
SELECT 
    nv.id_nhan_vien,
    nv.ho_ten,
    t.trinh_do,
    b.ten_bo_phan,
    nv.sdt,
    nv.dia_chi
FROM
    hop_dong h
        JOIN
    nhan_vien nv ON h.id_nhan_vien = nv.id_nhan_vien
    join trinh_do t on t.id_trinh_do=nv.id_trinh_do
    join bo_phan b on b.id_bo_phan=nv.id_bo_phan
WHERE
    YEAR(h.ngay_lam_hop_dong) IN (2018 , 2019)
GROUP BY h.id_nhan_vien
HAVING COUNT(h.ngay_lam_hop_dong) <= 3


