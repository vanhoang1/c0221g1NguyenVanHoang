package Quan_ly_hoa_don.Models;

import Quan_ly_hoa_don.Commons.CsvToString;

public abstract class KhachHang implements CsvToString {
    String maKhachHang;
    String hoTen;


    public KhachHang() {
    }

    public KhachHang(String maKhachHang, String hoTen) {
        this.maKhachHang = maKhachHang;
        this.hoTen = hoTen;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }



    @Override
    public String toString() {
        return
                "maKhachHang='" + maKhachHang + '\'' +
                ", hoTen='" + hoTen +
                ", ";
    }

    @Override
    public String toCsv() {
        return maKhachHang +
                "," + hoTen ;

    }

    @Override
    public void toObject(String[] list) {
        setMaKhachHang(list[0]);
        setHoTen(list[1]);
    }
}
