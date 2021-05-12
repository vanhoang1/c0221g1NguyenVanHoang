package Kiem_tra.Models;

import hang_chua.WriteRead.CsvToString;

public  class NhomDanhBa implements CsvToString {
    String nhomDanhba;

    public NhomDanhBa() {
    }

    public NhomDanhBa(String nhomDanhba) {
        this.nhomDanhba = nhomDanhba;
    }

    public String getNhomDanhba() {
        return nhomDanhba;
    }

    public void setNhomDanhba(String nhomDanhba) {
        this.nhomDanhba = nhomDanhba;
    }

    @Override
    public String toCsv() {
        return nhomDanhba;
    }

    @Override
    public String toString() {
        return "NhomDanhBa{" +
                "nhomDanhba='" + nhomDanhba + '\'' +
                '}';
    }

    @Override
    public void toObject(String[] list) {
        setNhomDanhba(list[0]);
    }
}
