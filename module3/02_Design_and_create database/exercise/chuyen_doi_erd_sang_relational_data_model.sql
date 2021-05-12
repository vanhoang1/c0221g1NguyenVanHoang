drop SCHEMA if exists quan_ly_vat_tu;
CREATE SCHEMA `quan_ly_vat_tu` ;
use quan_ly_vat_tu;
CREATE TABLE phieu_xuat (
    ma_phieu_xuat INT NOT NULL UNIQUE AUTO_INCREMENT,
    ngay_xuat DATE,
    PRIMARY KEY (ma_phieu_xuat)
);
CREATE TABLE vat_tu (
    ma_vat_tu INT NOT NULL UNIQUE AUTO_INCREMENT,
    ten_vat_tu VARCHAR(45),
    PRIMARY KEY (ma_vat_tu)
);
CREATE TABLE chi_tiet_phieu_xuat (
    ma_chi_tiet_phieu_xuat INT NOT NULL UNIQUE AUTO_INCREMENT,
    ma_phieu_xuat INT,
    ma_vat_tu INT,
    don_gia_xuat INT,
    so_luong_xuat INT,
    PRIMARY KEY (ma_chi_tiet_phieu_xuat),
    FOREIGN KEY (ma_phieu_xuat)
        REFERENCES phieu_xuat (ma_phieu_xuat),
    FOREIGN KEY (ma_vat_tu)
        REFERENCES vat_tu (ma_vat_tu)
);
CREATE TABLE phieu_nhap (
    ma_phieu_nhap INT NOT NULL UNIQUE AUTO_INCREMENT,
    ngay_nhap DATE,
    PRIMARY KEY (ma_phieu_nhap)
);
CREATE TABLE chi_tiet_phieu_nhap (
    ma_chi_tiet_phieu_nhap INT NOT NULL UNIQUE AUTO_INCREMENT,
    ma_phieu_nhap INT,
    ma_vat_tu INT,
    don_gia_nhap INT,
    so_luong_nhap INT,
    PRIMARY KEY (ma_chi_tiet_phieu_nhap),
    FOREIGN KEY (ma_phieu_nhap)
        REFERENCES phieu_nhap (ma_phieu_nhap),
    FOREIGN KEY (ma_vat_tu)
        REFERENCES vat_tu (ma_vat_tu)
);
CREATE TABLE nha_cung_cap (
    ma_nha_cung_cap INT NOT NULL UNIQUE AUTO_INCREMENT,
    ten_nha_cung_cap VARCHAR(23),
    dia_chi VARCHAR(45),
    sdt INT,
    PRIMARY KEY (ma_nha_cung_cap)
);
CREATE TABLE don_dat_hang (
    ma_don_dat_hang INT NOT NULL UNIQUE AUTO_INCREMENT,
    ma_nha_cung_cap INT,
    ngay_dat_hang DATE,
    PRIMARY KEY (ma_don_dat_hang),
    FOREIGN KEY (ma_nha_cung_cap)
        REFERENCES nha_cung_cap (ma_nha_cung_cap)
);
CREATE TABLE chi_tiet_don_dat_hang (
    ma_chi_tiet_don_dat_hang INT NOT NULL UNIQUE AUTO_INCREMENT,
    ma_don_dat_hang INT,
    ma_vat_tu INT,
    PRIMARY KEY (ma_chi_tiet_don_dat_hang),
    FOREIGN KEY (ma_don_dat_hang)
        REFERENCES don_dat_hang (ma_don_dat_hang),
    FOREIGN KEY (ma_vat_tu)
        REFERENCES vat_tu (ma_vat_tu)
);



