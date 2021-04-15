package ss17_Biary_Serializa.bai_tap;

public class SanPham {
    private  int maSanPham;
    private  String tanSanPham;
    private  String hangSanPham;
    private  double gia;

    public SanPham() {
    }

    public SanPham(int maSanPham, String tanSanPham, String hangSanPham, double gia) {
        this.maSanPham = maSanPham;
        this.tanSanPham = tanSanPham;
        this.hangSanPham = hangSanPham;
        this.gia = gia;
    }

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTanSanPham() {
        return tanSanPham;
    }

    public void setTanSanPham(String tanSanPham) {
        this.tanSanPham = tanSanPham;
    }

    public String getHangSanPham() {
        return hangSanPham;
    }

    public void setHangSanPham(String hangSanPham) {
        this.hangSanPham = hangSanPham;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "maSanPham=" + maSanPham +
                ", tanSanPham='" + tanSanPham + '\'' +
                ", hangSanPham='" + hangSanPham + '\'' +
                ", gia=" + gia +
                '}'+"\n";
    }
}
