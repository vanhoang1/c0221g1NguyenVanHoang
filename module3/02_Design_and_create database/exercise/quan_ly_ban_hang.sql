drop schema if exists quan_ly_ban_hang;
CREATE SCHEMA `quan_ly_ban_hang` ;
use quan_ly_ban_hang;
create table khach_hang(
ma_khach_hang INT NOT NULL unique AUTO_INCREMENT,
ten_khach_hang varchar(50),
tuoi_khach_hang int ,
primary key(ma_khach_hang)
);
create table dat_hang(
ma_dat_hang INT NOT NULL unique AUTO_INCREMENT,
ma_khach_hang INT,
ngay_dat_hang date,
primary key (ma_dat_hang),
foreign key(ma_khach_hang) references khach_hang(ma_khach_hang) 
);
create table san_pham(
ma_san_pham INT NOT NULL unique AUTO_INCREMENT,
ten_san_pham varchar(50),
gia_san_pham int,
primary key (ma_san_pham)
);
create table chi_tiet_dat_hang(
ma_chi_tiet_dat_hang INT NOT NULL unique AUTO_INCREMENT,
ma_san_pham INT,
ma_dat_hang INT,
primary key (ma_chi_tiet_dat_hang),
foreign key (ma_san_pham) references san_pham(ma_san_pham),
foreign key (ma_dat_hang) references dat_hang(ma_dat_hang)
);
