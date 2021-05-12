package Quan_ly_hoa_don.Models;

import Quan_ly_hoa_don.Commons.CsvToString;

public abstract class HoaDon implements CsvToString {
    String maHoaDon;
    String ngayRaHoaDon;

    public HoaDon() {
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getNgayRaHoaDon() {
        return ngayRaHoaDon;
    }

    public void setNgayRaHoaDon(String ngayRaHoaDon) {
        this.ngayRaHoaDon = ngayRaHoaDon;
    }

    @Override
    public String toString() {
        return
                "maHoaDon='" + maHoaDon + '\'' +
                ", ngayRaHoaDon='" + ngayRaHoaDon + '\'' +
                ',';
    }
}
