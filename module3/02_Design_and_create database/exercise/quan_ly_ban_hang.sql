drop schema if exists quan_ly_ban_hang;
CREATE SCHEMA `quan_ly_ban_hang` ;
use quan_ly_ban_hang;
CREATE TABLE khach_hang (
    ma_khach_hang INT NOT NULL UNIQUE AUTO_INCREMENT,
    ten_khach_hang VARCHAR(50),
    tuoi_khach_hang INT,
    PRIMARY KEY (ma_khach_hang)
);
CREATE TABLE dat_hang (
    ma_dat_hang INT NOT NULL UNIQUE AUTO_INCREMENT,
    ma_khach_hang INT,
    ngay_dat_hang DATE,
	tong_tien_hoa_don int,
    PRIMARY KEY (ma_dat_hang),
    FOREIGN KEY (ma_khach_hang)
        REFERENCES khach_hang (ma_khach_hang)
);
CREATE TABLE san_pham (
    ma_san_pham INT NOT NULL UNIQUE AUTO_INCREMENT,
    ten_san_pham VARCHAR(50),
    gia_san_pham INT,
    PRIMARY KEY (ma_san_pham)
);
CREATE TABLE chi_tiet_dat_hang (
    ma_chi_tiet_dat_hang INT NOT NULL UNIQUE AUTO_INCREMENT,
    ma_san_pham INT,
    ma_dat_hang INT,
    so_luong int,
    unique(ma_san_pham,ma_dat_hang),
    PRIMARY KEY (ma_chi_tiet_dat_hang),
    FOREIGN KEY (ma_san_pham)
        REFERENCES san_pham (ma_san_pham),
    FOREIGN KEY (ma_dat_hang)
        REFERENCES dat_hang (ma_dat_hang)
);
insert into khach_hang(ten_khach_hang,tuoi_khach_hang)
value ("Minh Quan",10),
 ("Ngoc Oanh",20),
 ("Hong Ha",50);
 insert into san_pham(ten_san_pham,gia_san_pham)
value ("May Giat",3),
 ("Tu Lanh",5),
 ("Dieu Hoa",7),
 ("Quat",1),
 ("Bep Dien",2);
 insert into dat_hang(ma_khach_hang,ngay_dat_hang)
 values(1,'2006-3-21'),
 (2,'2006-3-23'),
 (1,'2006-3-16');
SET GLOBAL FOREIGN_KEY_CHECKS=0;
 insert into chi_tiet_dat_hang(ma_san_pham,ma_dat_hang,so_luong)
 value(1,1,3),
 (1,3,7),
 (1,4,2),
 (2,1,1),
 (3,1,8),
 (2,5,4),
 (2,3,3);