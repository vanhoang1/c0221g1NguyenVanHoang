-- DAY 2
-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
use case_study;
SELECT 
    *
FROM
    nhan_vien
WHERE
    ho_ten REGEXP '^[H|K|T]\w{0,15}$';
 -- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
SELECT 
    *
FROM
    khach_hang
WHERE
    dia_chi REGEXP '^Đà Nẵng|Quảng Trị$'
        AND 2021 - YEAR(ngay_sinh) <= 50
        AND 2021 - YEAR(ngay_sinh) >= 18;
 -- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
 SELECT 
    COUNT(h.id_khach_hang) AS dem, h.id_khach_hang
FROM
    hop_dong h
        JOIN
    khach_hang k ON k.id_khach_hang = h.id_khach_hang
WHERE
    k.id_loai_khach = 1
GROUP BY id_khach_hang
ORDER BY dem;
 -- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
 SELECT 
    k.id_khach_hang,
    h.id_khach_hang,
    k.ho_ten,
    lk.ten_loai_khach,
    h.id_hop_dong,
    d.ten_dich_vu,
    h.ngay_lam_hop_dong,
    h.ngay_ket_thuc,
    SUM(d.chi_phi_thue + ct.so_luong * dvdk.gia) AS 'tong_tien'
FROM
    khach_hang k
        left JOIN
    hop_dong AS h ON h.id_khach_hang = k.id_khach_hang
        left JOIN
    dich_vu d ON h.id_dich_vu = d.id_dich_vu
        left JOIN
    loai_khach lk ON lk.id_loai_khach = k.id_loai_khach
        left JOIN
    chi_tiet_hop_dong ct ON ct.id_hop_dong = h.id_hop_dong
        left JOIN
    dich_vu_di_kem dvdk ON dvdk.id_dich_vu_di_kem = ct.id_dich_vu_di_kem
GROUP BY h.id_khach_hang;