package Quan_ly_hoa_don.Models;

public class KhachHangVietNam extends KhachHang {
    String loaiKhachHang;
    int dinhMucTieuThu;

    public KhachHangVietNam() {
    }

    public KhachHangVietNam(String maKhachHang, String hoTen, String loaiKhachHang, int dinhMucTieuThu) {
        super(maKhachHang, hoTen);
        this.loaiKhachHang = loaiKhachHang;
        this.dinhMucTieuThu = dinhMucTieuThu;
    }

    public String getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(String loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    public int getDinhMucTieuThu() {
        return dinhMucTieuThu;
    }

    public void setDinhMucTieuThu(int dinhMucTieuThu) {
        this.dinhMucTieuThu = dinhMucTieuThu;
    }

    @Override
    public String toString() {
        return "KhachHangVietNam{" + super.toString() +
                "loaiKhachHang='" + loaiKhachHang + '\'' +
                ", dinhMucTieuThu=" + dinhMucTieuThu +
                "} " ;
    }

    @Override
    public String toCsv() {
        return super.toCsv()+
                "," + loaiKhachHang +
                "," + dinhMucTieuThu;
    }

    @Override
    public void toObject(String[] list) {
        super.toObject(list);
        setLoaiKhachHang(list[2]);
        setDinhMucTieuThu(Integer.parseInt(list[3]));
    }
}
