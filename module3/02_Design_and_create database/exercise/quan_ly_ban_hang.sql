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
    PRIMARY KEY (ma_chi_tiet_dat_hang),
    FOREIGN KEY (ma_san_pham)
        REFERENCES san_pham (ma_san_pham),
    FOREIGN KEY (ma_dat_hang)
        REFERENCES dat_hang (ma_dat_hang)
);
insert into quan_ly_ban_hang.khach_hang(ten_khach_hang,tuoi_khach_hang)
value ("hoang",11),
 ("hoang",11),
 ("nhung",22),
 ("nhung",22),
 ("nhung",22),
 ("tam",33),
 ("thuy",44);
 insert into quan_ly_ban_hang.san_pham(ten_san_pham,gia_san_pham)
value ("mi tom",1000),
 ("mi tom",1000),
 ("nuoc loc",1000),
 ("tra",300),
 ("caffee",12),
 ("mi tom",1);