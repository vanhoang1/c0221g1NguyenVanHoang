use quan_ly_ban_hang;

 -- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
SELECT 
    ct.ma_san_pham, d.ngay_dat_hang, sum(ct.so_luong * s.gia_san_pham) as tong_tien
FROM
    san_pham s
        JOIN
    chi_tiet_dat_hang ct ON s.ma_san_pham = ct.ma_san_pham
        JOIN
    dat_hang d ON d.ma_dat_hang = ct.ma_dat_hang
    group by s.ma_san_pham;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
 SELECT 
    dh.ma_khach_hang, ct.ma_san_pham, sp.ten_san_pham
FROM
    chi_tiet_dat_hang ct
        JOIN
    dat_hang dh ON dh.ma_dat_hang = ct.ma_dat_hang
        JOIN
    san_pham sp ON sp.ma_san_pham = ct.ma_san_pham;
 -- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
SELECT 
    kh.ten_khach_hang
FROM
    dat_hang dh
        RIGHT JOIN
    khach_hang kh ON dh.ma_khach_hang = kh.ma_khach_hang
WHERE
    dh.ma_khach_hang IS NULL;
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn.
-- Giá bán của từng loại được tính = odQTY*pPrice)
select ct.ma_dat_hang,dh.ngay_dat_hang,sum(sp.gia_san_pham*ct.so_luong) as tong_tien from dat_hang dh join chi_tiet_dat_hang ct 
on dh.ma_dat_hang=ct.ma_dat_hang join san_pham sp
on sp.ma_san_pham=ct.ma_san_pham
group by ct.ma_dat_hang

