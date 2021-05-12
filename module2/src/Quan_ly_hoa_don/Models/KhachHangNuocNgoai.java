package Quan_ly_hoa_don.Models;

public class KhachHangNuocNgoai extends KhachHang {
    String quocTich;

    public KhachHangNuocNgoai() {
    }

    public KhachHangNuocNgoai(String maKhachHang, String hoTen, String quocTich) {
        super(maKhachHang, hoTen);
        this.quocTich = quocTich;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    @Override
    public String toString() {
        return "KhachHangNuocNgoai{" + super.toString() +
                "quocTich='" + quocTich + '\'' +
                "} " ;
    }

    @Override
    public String toCsv() {
        return super.toCsv()+ "," + quocTich;
    }

    @Override
    public void toObject(String[] list) {
        super.toObject(list);
        setQuocTich(list[2]);
    }
}
