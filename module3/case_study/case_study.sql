drop schema if exists `case_study`;
CREATE SCHEMA  `case_study` ;
use `case_study`;
CREATE TABLE vi_tri (
    id_vi_tri INT NOT NULL AUTO_INCREMENT,
    ten_vi_tri VARCHAR(45),
    PRIMARY KEY (id_vi_tri)
);
CREATE TABLE trinh_do (
    id_trinh_do INT NOT NULL AUTO_INCREMENT,
    trinh_do VARCHAR(45),
    PRIMARY KEY (id_trinh_do)
);
CREATE TABLE bo_phan (
    id_bo_phan INT NOT NULL AUTO_INCREMENT,
    ten_bo_phan VARCHAR(45),
    PRIMARY KEY (id_bo_phan)
);
CREATE TABLE nhan_vien (
    id_nhan_vien INT NOT NULL AUTO_INCREMENT,
    ho_ten VARCHAR(45),
    id_vi_tri INT,
    id_trinh_do INT,
    id_bo_phan INT,
    ngay_sinh DATE,
    so_cmtdn VARCHAR(45),
    luong VARCHAR(45),
    sdt VARCHAR(45),
    email VARCHAR(45),
    dia_chi VARCHAR(45),
    PRIMARY KEY (id_nhan_vien),
    FOREIGN KEY (id_vi_tri)
        REFERENCES vi_tri (id_vi_tri),
    FOREIGN KEY (id_trinh_do)
        REFERENCES trinh_do (id_trinh_do),
    FOREIGN KEY (id_bo_phan)
        REFERENCES bo_phan (id_bo_phan)
);
CREATE TABLE dich_vu_di_kem (
    id_dich_vu_di_kem INT NOT NULL AUTO_INCREMENT,
    ten_dich_vu_di_kem VARCHAR(45),
    gia INT,
    don_vi INT,
    trang_thai_kha_dung VARCHAR(45),
    PRIMARY KEY (id_dich_vu_di_kem)
);
CREATE TABLE loai_khach (
    id_loai_khach INT NOT NULL AUTO_INCREMENT,
    ten_loai_khach VARCHAR(45),
    PRIMARY KEY (id_loai_khach)
);
CREATE TABLE khach_hang (
    id_khach_hang INT NOT NULL AUTO_INCREMENT,
    id_loai_khach INT,
    ho_ten VARCHAR(45),
    ngay_sinh DATE,
    so_cmtdn VARCHAR(45),
    sdt VARCHAR(45),
    email VARCHAR(45),
    dia_chi VARCHAR(45),
    PRIMARY KEY (id_khach_hang),
    FOREIGN KEY (id_loai_khach)
        REFERENCES loai_khach (id_loai_khach)
);
CREATE TABLE kieu_thue (
    id_kieu_thue INT NOT NULL AUTO_INCREMENT,
    ten_kieu_thue VARCHAR(45),
    gia INT,
    PRIMARY KEY (id_kieu_thue)
);
CREATE TABLE loai_dich_vu (
    id_loai_dich_vu INT NOT NULL AUTO_INCREMENT,
    ten_loai_dich_vu VARCHAR(45),
    PRIMARY KEY (id_loai_dich_vu)
);
CREATE TABLE dich_vu (
    id_dich_vu INT NOT NULL AUTO_INCREMENT,
    ten_dich_vu VARCHAR(45),
    dien_tich INT,
    so_tang INT,
    so_nguoi_toi_da VARCHAR(45),
    chi_phi_thue VARCHAR(45),
    id_kieu_thue INT,
    id_loai_dich_vu INT,
    TrangThai VARCHAR(45),
    PRIMARY KEY (id_dich_vu),
    FOREIGN KEY (id_kieu_thue)
        REFERENCES kieu_thue (id_kieu_thue),
    FOREIGN KEY (id_loai_dich_vu)
        REFERENCES loai_dich_vu (id_loai_dich_vu)
);
CREATE TABLE hop_dong (
    id_hop_dong INT NOT NULL AUTO_INCREMENT,
    id_nhan_vien INT,
    id_khach_hang INT,
    id_dich_vu INT,
    ngay_lam_hop_dong DATE,
    ngay_ket_thuc DATE,
    tien_dat_coc INT,
    tong_tien INT,
    PRIMARY KEY (id_hop_dong),
    FOREIGN KEY (id_nhan_vien)
        REFERENCES nhan_vien (id_nhan_vien),
    FOREIGN KEY (id_khach_hang)
        REFERENCES khach_hang (id_khach_hang),
    FOREIGN KEY (id_dich_vu)
        REFERENCES dich_vu (id_dich_vu)
);
CREATE TABLE chi_tiet_hop_dong (
    id_chi_tiet_hop_dong INT NOT NULL AUTO_INCREMENT,
    id_hop_dong INT,
    id_dich_vu_di_kem INT,
    so_luong INT,
    PRIMARY KEY (id_chi_tiet_hop_dong),
    FOREIGN KEY (id_dich_vu_di_kem)
        REFERENCES dich_vu_di_kem (id_dich_vu_di_kem),
    FOREIGN KEY (id_hop_dong)
        REFERENCES hop_dong (id_hop_dong)
);
insert into trinh_do(trinh_do)
value("Trung cấp"),
("Trung cấp"),
("Đại học "),
("sau đại học");
insert into bo_phan(ten_bo_phan)
value ("Sale – Marketing"),
("Hành Chính"),
("Phục vụ"),
("Quản lý");
insert into vi_tri(ten_vi_tri)
value("Lễ tân"),
("phục vụ"),
("chuyên viên"),
("giám sát"),
("quản lý"),
("giám đốc");
insert into nhan_vien(ho_ten,id_vi_tri,id_trinh_do,id_bo_phan,ngay_sinh,so_cmtdn,luong,sdt,email,dia_chi)
value ("Hoàng",1,1,1,"1996-8-2",88898990,2000,1111,'abc@gmail.com','An Giang'),
("Tấn",2,2,2,"1996-8-2",88898990,2000,1112,'abc@gmail.com','Hải Dương'),
("Thúy",3,3,3,"1991-1-2",88898990,2000,1113,'abc@gmail.com','Hải Dương'),
("Trang",1,2,3,"1996-5-2",88898990,2000,1114,'abc@gmail.com','Đà Nẵng'),
("Khanh",3,2,1,"1988-7-2",88898990,2000,1115,'abc@gmail.com','Hải Phòng');
insert into loai_khach(ten_loai_khach)
 value("Diamond"),
 ("Platinium"),
 ("Gold"),
 ("sivel"),
 ("Gold")
 ;
 insert into khach_hang (id_loai_khach,ho_ten,ngay_sinh,so_cmtdn,sdt,email,dia_chi)
 value(1,'nhung',"1996-8-2",12345122,1221,'aaa@gmail.com','Đà Nẵng'),
 (1,'trang',"1946-8-2",454435345,213,'aaa@gmail.com','Đà Nẵng'),
 (2,'hung',"1997-3-5",21112321,123,'aaa@gmail.com','Quảng Trị'),
 (2,'abc',"1986-3-5",21112321,123,'aaa@gmail.com','Quảng Trị'),
 (2,'xyz',"1946-3-5",22,12223,'aa2a@gmail.com','Hải Phòng');
insert into kieu_thue(ten_kieu_thue,gia)
value ('năm',10000),
('tháng',5000),
('ngày',3000),
('giờ',1000);
insert into loai_dich_vu(ten_loai_dich_vu)
value('Villa'),
('House'),
('Room');
insert into dich_vu(ten_dich_vu,dien_tich,so_tang,so_nguoi_toi_da,chi_phi_thue,id_kieu_thue,id_loai_dich_vu,TrangThai)
value('villaBig',123,3,12,'123422',1,1,'off'),
('villaSmall',111,4,12,'123422',1,1,'off'),
('houseBig',1111,4,12,'12223422',2,2,'off'),
('roomBig',12314,4,12,'555',3,1,'off'),
('houseSmall',111,4,12,'1111',3,3,'off'),
('roomSmall',111,4,12,'323',1,2,'off');
insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung)
value ('massage',123123,1,'ok'),
('karaoke',123123,1,'ok'),
('food',123123,1,'ok'),
('water',123123,1,'ok'),
('car',123123,1,'ok');
insert into hop_dong(id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc)
value(1,1,1,'2021-5-1','2021-6-1',111111),
(2,2,2,'2021-5-1','2021-6-1',111111),
(3,3,3,'2021-5-1','2021-6-1',111111),
(3,3,3,'2021-5-1','2021-6-1',111111),
(3,3,3,'2021-5-1','2021-6-1',111111),
(3,3,3,'2021-5-1','2021-6-1',111111),
(3,3,3,'2021-5-1','2021-6-1',111111),
(1,1,1,'2021-5-1','2021-6-1',111111),
(1,1,1,'2021-5-1','2021-6-1',111111),
(1,1,1,'2021-5-1','2021-6-1',111111),
(3,3,3,'2021-5-1','2021-6-1',111111),
(1,2,3,'2021-5-1','2021-6-1',111111),
(3,2,1,'2021-5-1','2021-6-1',111111);
insert into chi_tiet_hop_dong(id_hop_dong,id_dich_vu_di_kem,so_luong)
value(1,1,123),
(2,2,456);

