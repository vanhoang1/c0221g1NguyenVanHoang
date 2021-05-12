package Quan_ly_hoa_don.Models;

public class ChiTietHoaDon<E extends KhachHang> extends HoaDon  {
    private   String maKhachHang;
    private int soLuong;
    private double donGia;
    private double thanhTien;
    private E chiTietKhachHang;

    public ChiTietHoaDon( int soLuong, double donGia, E chiTietKhachHang) {
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.chiTietKhachHang = chiTietKhachHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setChiTietKhachHang(E chiTietKhachHang) {
        this.chiTietKhachHang = chiTietKhachHang;
    }

    public String getMaKhachHang() {
        return this.chiTietKhachHang.getMaKhachHang();
    }

    public double getThanhTien() {
        if(chiTietKhachHang instanceof KhachHangVietNam){
            int dinhMucTieuThu=((KhachHangVietNam) chiTietKhachHang).dinhMucTieuThu;
            if(getSoLuong()>dinhMucTieuThu){
                return getDonGia()* getSoLuong()+getDonGia()* (getSoLuong()-dinhMucTieuThu)*getDonGia()*2.5;
            }
        }
        return getDonGia()* getSoLuong();
    }

    @Override
    public String toCsv() {
        return null;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{"
                + super.toString()+
                "maKhachHang='" + maKhachHang + '\'' +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", thanhTien=" + thanhTien +
                ", chiTietKhachHang=" + chiTietKhachHang +
                "} " ;
    }

    @Override
    public void toObject(String[] list) {
            setMaHoaDon(list[0]);
            setNgayRaHoaDon(list[1]);
    }
}
