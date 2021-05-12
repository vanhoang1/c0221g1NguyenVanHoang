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
    ho_ten INT,
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
    do_nguoi_toi_da VARCHAR(45),
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
    id_hop_dong INT NOT NULL UNIQUE AUTO_INCREMENT,
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
CREATE TABLE hop_dong_chi_tiet (
    id_hop_dong_chi_tiet INT NOT NULL AUTO_INCREMENT,
    id_hop_dong INT,
    id_dich_vu_di_kem INT,
    so_luong INT,
    PRIMARY KEY (id_hop_dong_chi_tiet),
    FOREIGN KEY (id_dich_vu_di_kem)
        REFERENCES dich_vu_di_kem (id_dich_vu_di_kem),
    FOREIGN KEY (id_hop_dong)
        REFERENCES hop_dong (id_hop_dong)
);
