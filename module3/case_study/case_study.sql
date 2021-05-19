drop schema if exists `case_study`;
CREATE SCHEMA if not exists `case_study` ;
use `case_study`;
CREATE TABLE vi_tri (
    id_vi_tri INT NOT NULL UNIQUE AUTO_INCREMENT,
    ten_vi_tri VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_vi_tri)
);
CREATE TABLE trinh_do (
    id_trinh_do INT NOT NULL UNIQUE AUTO_INCREMENT,
    trinh_do VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_trinh_do)
);
CREATE TABLE bo_phan (
    id_bo_phan INT NOT NULL UNIQUE AUTO_INCREMENT,
    ten_bo_phan VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_bo_phan)
);
CREATE TABLE nhan_vien (
    id_nhan_vien INT NOT NULL UNIQUE AUTO_INCREMENT,
    ho_ten VARCHAR(45) NOT NULL,
    id_vi_tri INT NOT NULL,
    id_trinh_do INT NOT NULL,
    id_bo_phan INT NOT NULL,
    ngay_sinh DATE NOT NULL,
    so_cmtdn VARCHAR(45),
    luong VARCHAR(45),
    sdt VARCHAR(45),
    email VARCHAR(45),
    dia_chi VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_nhan_vien),
    CONSTRAINT fk_nv_vt FOREIGN KEY (id_vi_tri)
        REFERENCES vi_tri (id_vi_tri)
        ON DELETE CASCADE,
    CONSTRAINT fk_nv_td FOREIGN KEY (id_trinh_do)
        REFERENCES trinh_do (id_trinh_do)
        ON DELETE CASCADE,
    CONSTRAINT fk_nv_bp FOREIGN KEY (id_bo_phan)
        REFERENCES bo_phan (id_bo_phan)
        ON DELETE CASCADE
);
CREATE TABLE dich_vu_di_kem (
    id_dich_vu_di_kem INT NOT NULL UNIQUE AUTO_INCREMENT,
    ten_dich_vu_di_kem VARCHAR(45) NOT NULL,
    gia INT NOT NULL,
    don_vi INT NOT NULL,
    trang_thai_kha_dung VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_dich_vu_di_kem)
);
CREATE TABLE loai_khach (
    id_loai_khach INT NOT NULL UNIQUE AUTO_INCREMENT,
    ten_loai_khach VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_loai_khach)
);
CREATE TABLE khach_hang (
    id_khach_hang INT NOT NULL UNIQUE AUTO_INCREMENT,
    id_loai_khach INT NOT NULL,
    ho_ten VARCHAR(45) NOT NULL,
    ngay_sinh DATE NOT NULL,
    so_cmtdn VARCHAR(45) UNIQUE,
    sdt VARCHAR(45),
    email VARCHAR(45),
    dia_chi VARCHAR(45),
    PRIMARY KEY (id_khach_hang),
    CONSTRAINT fk_kh_lk FOREIGN KEY (id_loai_khach)
        REFERENCES loai_khach (id_loai_khach)
        ON DELETE CASCADE
);
CREATE TABLE kieu_thue (
    id_kieu_thue INT NOT NULL UNIQUE AUTO_INCREMENT,
    ten_kieu_thue VARCHAR(45) NOT NULL,
    gia INT NOT NULL,
    PRIMARY KEY (id_kieu_thue)
);
CREATE TABLE loai_dich_vu (
    id_loai_dich_vu INT NOT NULL AUTO_INCREMENT,
    ten_loai_dich_vu VARCHAR(45) NOT NULL,
    PRIMARY KEY (id_loai_dich_vu)
);
CREATE TABLE dich_vu (
    id_dich_vu INT NOT NULL UNIQUE AUTO_INCREMENT,
    ten_dich_vu VARCHAR(45) NOT NULL,
    dien_tich INT NOT NULL,
    so_tang INT NOT NULL,
    so_nguoi_toi_da VARCHAR(45) NOT NULL,
    chi_phi_thue VARCHAR(45) NOT NULL,
    id_kieu_thue INT NOT NULL,
    id_loai_dich_vu INT NOT NULL,
    TrangThai VARCHAR(45),
    PRIMARY KEY (id_dich_vu),
    CONSTRAINT fk_dv_kt FOREIGN KEY (id_kieu_thue)
        REFERENCES kieu_thue (id_kieu_thue)
        ON DELETE CASCADE,
    CONSTRAINT fk_dv_ldv FOREIGN KEY (id_loai_dich_vu)
        REFERENCES loai_dich_vu (id_loai_dich_vu)
        ON DELETE CASCADE
);
CREATE TABLE hop_dong (
    id_hop_dong INT NOT NULL UNIQUE AUTO_INCREMENT,
    id_nhan_vien INT NULL,
    id_khach_hang INT NULL,
    id_dich_vu INT NULL,
    ngay_lam_hop_dong DATE NOT NULL,
    ngay_ket_thuc DATE,
    tien_dat_coc INT,
    tong_tien INT,
    PRIMARY KEY (id_hop_dong),
    CONSTRAINT fk_hd_nv FOREIGN KEY (id_nhan_vien)
        REFERENCES nhan_vien (id_nhan_vien)
        ON DELETE CASCADE,
    CONSTRAINT fk_hd_kh FOREIGN KEY (id_khach_hang)
        REFERENCES khach_hang (id_khach_hang)
        ON DELETE CASCADE,
    CONSTRAINT fk_hd_dv FOREIGN KEY (id_dich_vu)
        REFERENCES dich_vu (id_dich_vu)
        ON DELETE CASCADE
);
CREATE TABLE chi_tiet_hop_dong (
    id_chi_tiet_hop_dong INT NOT NULL UNIQUE AUTO_INCREMENT,
    id_hop_dong INT NOT NULL,
    id_dich_vu_di_kem INT,
    so_luong INT,
    UNIQUE (id_hop_dong , id_dich_vu_di_kem),
    PRIMARY KEY (id_chi_tiet_hop_dong),
    CONSTRAINT fk_ct_dvdk FOREIGN KEY (id_dich_vu_di_kem)
        REFERENCES dich_vu_di_kem (id_dich_vu_di_kem)
        ON DELETE CASCADE,
    CONSTRAINT fk_ct_hd FOREIGN KEY (id_hop_dong)
        REFERENCES hop_dong (id_hop_dong)
        ON DELETE CASCADE
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
 (2,'xyz',"1946-3-5",22,567890,'aa2a@gmail.com','HCM'),
 (3,'xyz',"1956-3-5",33,233413,'aa2a@gmail.com','Hải Phòng'),
 (4,'xyz',"1966-3-5",44,12123,'aa2a@gmail.com','Gia lai'),
 (5,'xyz',"1976-3-5",55,111111,'aa2a@gmail.com','Kom tum');
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
value(1,1,7,'2021-05-1','2021-06-1',111111),
(2,2,8,'2021-05-1','2021-06-01',111111),
(1,2,6,'2020-11-1','2021-06-01',111111),
(1,2,6,'2020-10-1','2021-06-01',111111),
(3,3,7,'2019-11-1','2021-06-01',111111),
(3,1,8,'2019-11-1','2021-06-01',111111),
(1,2,6,'2019-11-1','2021-06-01',111111),
(1,2,7,'2019-11-1','2021-06-01',111111),
(1,2,8,'2018-05-1','2021-06-01',111111),
(3,1,6,'2018-05-1','2021-06-01',111111),
(3,3,7,'2020-01-1','2021-06-01',111111),
(3,3,8,'2020-02-1','2021-06-01',111111),
(3,3,7,'2020-03-1','2021-06-01',111111),
(3,3,6,'2020-04-1','2021-06-01',111111);
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
INSERT INTO `case_study`.`hop_dong` (`id_nhan_vien`, `id_khach_hang`, `id_dich_vu`, `ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`) VALUES ('4', '4', '4', '2019-01-01', '2021-06-01', '111111');
INSERT INTO `case_study`.`hop_dong` (`id_nhan_vien`, `id_khach_hang`, `id_dich_vu`, `ngay_lam_hop_dong`, `ngay_ket_thuc`, `tien_dat_coc`) VALUES ('5', '5', '5', '2019-02-01', '2021-06-01', '222222');
INSERT INTO `case_study`.`chi_tiet_hop_dong` (`id_hop_dong`, `id_dich_vu_di_kem`, `so_luong`) VALUES ('11', '1', '12');
INSERT INTO `case_study`.`chi_tiet_hop_dong` (`id_hop_dong`, `id_dich_vu_di_kem`, `so_luong`) VALUES ('12', '3', '3');
SET FOREIGN_KEY_CHECKS=1;