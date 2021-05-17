drop schema if exists `case_study`;
CREATE SCHEMA if not exists `case_study` ;
use `case_study`;
CREATE TABLE vi_tri (
    id_vi_tri INT NOT NULL unique AUTO_INCREMENT,
    ten_vi_tri VARCHAR(45)  NOT NULL,
    PRIMARY KEY (id_vi_tri)
);
CREATE TABLE trinh_do (
    id_trinh_do INT NOT NULL unique AUTO_INCREMENT,
    trinh_do VARCHAR(45)  NOT NULL,
    PRIMARY KEY (id_trinh_do)
);
CREATE TABLE bo_phan (
    id_bo_phan INT NOT NULL unique AUTO_INCREMENT,
    ten_bo_phan VARCHAR(45)  NOT NULL,
    PRIMARY KEY (id_bo_phan)
);
CREATE TABLE nhan_vien (
    id_nhan_vien INT NOT NULL unique AUTO_INCREMENT,
    ho_ten VARCHAR(45)  NOT NULL,
    id_vi_tri INT  NOT NULL,
    id_trinh_do INT  NOT NULL,
    id_bo_phan INT  NOT NULL,
    ngay_sinh DATE  NOT NULL,
    so_cmtdn VARCHAR(45) ,
    luong VARCHAR(45),
    sdt VARCHAR(45),
    email VARCHAR(45),
    dia_chi VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_nhan_vien),
    FOREIGN KEY (id_vi_tri)
        REFERENCES vi_tri (id_vi_tri),
    FOREIGN KEY (id_trinh_do)
        REFERENCES trinh_do (id_trinh_do),
    FOREIGN KEY (id_bo_phan)
        REFERENCES bo_phan (id_bo_phan)
);
CREATE TABLE dich_vu_di_kem (
    id_dich_vu_di_kem INT NOT NULL unique AUTO_INCREMENT,
    ten_dich_vu_di_kem VARCHAR(45)  NOT NULL,
    gia INT  NOT NULL,
    don_vi INT  NOT NULL,
    trang_thai_kha_dung VARCHAR(45)  NOT NULL,
    PRIMARY KEY (id_dich_vu_di_kem)
);
CREATE TABLE loai_khach (
    id_loai_khach INT NOT NULL unique AUTO_INCREMENT,
    ten_loai_khach VARCHAR(45)  NOT NULL,
    PRIMARY KEY (id_loai_khach)
);
CREATE TABLE khach_hang (
    id_khach_hang INT NOT NULL unique AUTO_INCREMENT,
    id_loai_khach INT  NOT NULL,
    ho_ten VARCHAR(45)  NOT NULL,
    ngay_sinh DATE  NOT NULL,
    so_cmtdn VARCHAR(45) unique,
    sdt VARCHAR(45),
    email VARCHAR(45),
    dia_chi VARCHAR(45),
    PRIMARY KEY (id_khach_hang),
    FOREIGN KEY (id_loai_khach)
        REFERENCES loai_khach (id_loai_khach)
);
CREATE TABLE kieu_thue (
    id_kieu_thue INT NOT NULL unique AUTO_INCREMENT,
    ten_kieu_thue VARCHAR(45)  NOT NULL,
    gia INT  NOT NULL,
    PRIMARY KEY (id_kieu_thue)
);
CREATE TABLE loai_dich_vu (
    id_loai_dich_vu INT NOT NULL AUTO_INCREMENT,
    ten_loai_dich_vu VARCHAR(45)  NOT NULL,
    PRIMARY KEY (id_loai_dich_vu)
);
CREATE TABLE dich_vu (
    id_dich_vu INT NOT NULL unique AUTO_INCREMENT,
    ten_dich_vu VARCHAR(45)  NOT NULL,
    dien_tich INT  NOT NULL,
    so_tang INT  NOT NULL,
    so_nguoi_toi_da VARCHAR(45)  NOT NULL,
    chi_phi_thue VARCHAR(45)  NOT NULL,
    id_kieu_thue INT  NOT NULL,
    id_loai_dich_vu INT  NOT NULL,
    TrangThai VARCHAR(45),
    PRIMARY KEY (id_dich_vu),
    FOREIGN KEY (id_kieu_thue)
        REFERENCES kieu_thue (id_kieu_thue),
    FOREIGN KEY (id_loai_dich_vu)
        REFERENCES loai_dich_vu (id_loai_dich_vu)
);
CREATE TABLE hop_dong (
    id_hop_dong INT NOT NULL unique AUTO_INCREMENT,
    id_nhan_vien INT  NOT NULL,
    id_khach_hang INT  NOT NULL,
    id_dich_vu INT  NOT NULL,
    ngay_lam_hop_dong DATE  NOT NULL,
    ngay_ket_thuc DATE ,
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
    id_chi_tiet_hop_dong INT NOT NULL unique AUTO_INCREMENT,
    id_hop_dong INT  NOT NULL,
    id_dich_vu_di_kem INT,
    so_luong INT,
    unique(id_hop_dong,id_dich_vu_di_kem),
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
 (1,'trang',"1946-8-2",123456,213,'aaa@gmail.com','Đà Nẵng'),
 (2,'hung',"1997-3-5",234567,123,'aaa@gmail.com','Quảng Trị'),
 (2,'abc',"1986-3-5",345678,123,'aaa@gmail.com','Quảng Trị'),
 (2,'xyz',"1946-3-5",22,567890,'aa2a@gmail.com','Hải Phòng');
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
('villaMedium',111,4,12,'3333',1,1,'off'),
('villaSmall',111,4,12,'111',1,1,'on'),
('houseBig',1111,4,12,'12223422',2,2,'on'),
('houseMedium',111,4,12,'123422',1,2,'off'),
('houseSmall',111,4,12,'1111',3,2,'off'),
('roomBig',12314,4,12,'55555',3,3,'ob'),
('roomMedium',111,4,12,'1111',1,3,'off'),
('roomSmall',111,4,12,'323',1,3,'off');
insert into dich_vu_di_kem(ten_dich_vu_di_kem,gia,don_vi,trang_thai_kha_dung)
value ('massage',123123,1,'ok'),
('karaoke',123123,1,'ok'),
('food',123123,1,'ok'),
('water',123123,1,'ok'),
('car',123123,1,'ok');
insert into hop_dong(id_nhan_vien,id_khach_hang,id_dich_vu,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc)
value(1,1,1,'2021-05-1','2021-06-1',111111),
(2,2,2,'2021-05-1','2021-06-01',111111),
(1,2,2,'2020-11-1','2021-06-01',111111),
(1,2,2,'2020-10-1','2021-06-01',111111),
(3,3,3,'2019-11-1','2021-06-01',111111),
(3,1,1,'2019-11-1','2021-06-01',111111),
(1,2,1,'2019-11-1','2021-06-01',111111),
(1,2,1,'2019-11-1','2021-06-01',111111),
(1,2,3,'2018-05-1','2021-06-01',111111),
(3,1,3,'2018-05-1','2021-06-01',111111),
(3,3,3,'2020-01-1','2021-06-01',111111),
(3,4,3,'2020-02-1','2021-06-01',111111),
(3,5,3,'2020-03-1','2021-06-01',111111),
(3,6,3,'2020-04-1','2021-06-01',111111);
insert into chi_tiet_hop_dong(id_hop_dong,id_dich_vu_di_kem,so_luong)
value(1,1,123),
(2,1,123),
(2,2,123),
(4,3,123),
(5,1,123),
(4,2,123),
(3,1,123),
(5,2,123),
(6,3,123),
(6,4,123),
(8,2,456);

insert into dich_vu(ten_dich_vu,dien_tich,so_tang,so_nguoi_toi_da,chi_phi_thue,id_kieu_thue,id_loai_dich_vu,TrangThai)
value('nhà lá',123,3,12,'123422',1,1,'off');
UPDATE `case_study`.`hop_dong` SET `ngay_lam_hop_dong` = '2020-01-01' WHERE (`id_hop_dong` = '3');
INSERT INTO `case_study`.`hop_dong` (`id_nhan_vien`, `id_khach_hang`, `id_dich_vu`, `ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`) VALUES ('4', '4', '4', '2019-01-01', '2021-06-01', '111111');
INSERT INTO `case_study`.`hop_dong` (`id_nhan_vien`, `id_khach_hang`, `id_dich_vu`, `ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`) VALUES ('5', '5', '5', '2019-02-01', '2021-06-01', '222222');
INSERT INTO `case_study`.`chi_tiet_hop_dong` (`id_hop_dong`, `id_dich_vu_di_kem`, `so_luong`) VALUES ('11', '1', '12');
INSERT INTO `case_study`.`chi_tiet_hop_dong` (`id_hop_dong`, `id_dich_vu_di_kem`, `so_luong`) VALUES ('12', '3', '3');