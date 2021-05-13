-- DAY 2
-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
use case_study;
insert into trinh_do(trinh_do)
value("10/10"),
("12/12"),
("đại học");
insert into bo_phan(ten_bo_phan)
value ("ban hang"),
("sale"),
("kho");
insert into vi_tri(ten_vi_tri)
value("boss"),
("quai"),
("culi");
insert into nhan_vien(ho_ten,id_vi_tri,id_trinh_do,id_bo_phan,ngay_sinh,so_cmtdn,luong,sdt)
value ("Hoàng",1,1,1,"1996-8-2",88898990,2000,1111),
("Tấn",2,2,2,"1996-8-2",88898990,2000,1112),
("Thúy",3,3,3,"1991-1-2",88898990,2000,1113),
("Trang",1,2,3,"1996-5-2",88898990,2000,1114),
("Khanh",3,2,1,"1988-7-2",88898990,2000,1115);

 select * from nhan_vien where ho_ten regexp '^[H|K|T]\\w{0,15}$';
 
 ;