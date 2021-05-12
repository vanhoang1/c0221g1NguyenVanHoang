package Kiem_tra.Models;

import hang_chua.WriteRead.CsvToString;

public class DanhBa implements CsvToString {
    String SDT;
    String nhomDanhba;
    String hoTen;
    String gioiTinh;
    String diaChi;
    String ngaySinh;
    String email;

    public DanhBa(String SDT, String nhomDanhba, String hoTen, String gioiTinh, String diaChi, String ngaySinh, String email) {
        this.SDT = SDT;
        this.nhomDanhba = nhomDanhba;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.ngaySinh = ngaySinh;
        this.email = email;
    }

    public DanhBa() {
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNhomDanhba() {
        return nhomDanhba;
    }

    public void setNhomDanhba(String nhomDanhba) {
        this.nhomDanhba = nhomDanhba;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "DanhBa{" +
                "SDT='" + SDT + '\'' +
                ", nhomDanhBa='" + nhomDanhba + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", gioiTinh='" + gioiTinh + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public String toCsv() {
        return SDT +
                "," + nhomDanhba +
                "," + hoTen +
                "," + gioiTinh +
                "," + diaChi +
                "," + ngaySinh +
                "," + email;
    }

    @Override
    public void toObject(String[] list) {
        setSDT(list[0]);
        setNhomDanhba(list[1]);
        setHoTen(list[2]);
        setGioiTinh(list[3]);
        setDiaChi(list[4]);
        setNgaySinh(list[5]);
        setEmail(list[6]);
    }
}
