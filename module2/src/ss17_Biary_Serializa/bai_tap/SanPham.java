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

    public SanPham(String splitDatum, String splitDatum1, String splitDatum2, String splitDatum3) {
        setMaSanPham(Integer.parseInt(splitDatum));
        setTanSanPham(splitDatum1);
        setHangSanPham(splitDatum2);
        setGia(Double.parseDouble(splitDatum3));
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
        return
                 maSanPham +
                "," + tanSanPham +
                "," + hangSanPham +
                "," + gia ;
    }
}
