package ss17_Biary_Serializa.bai_tap;


import java.io.IOException;
import java.util.ArrayList;


public class QuanLySanPham extends ReadWrite {
    String name = "hoang";
    ArrayList<SanPham> arrSanPham;
    static final String NGUON = "D:\\C0221G1_NguyenVanHoang\\module2\\src\\ss17_Biary_Serializa\\bai_tap\\ccc";


    public QuanLySanPham() {
        arrSanPham = new ArrayList<>();
    }

    public void add(int ma, String name, String hang, double gia) {
        SanPham newSP = new SanPham(ma, name, hang, gia);
        arrSanPham.add(newSP);
    }

    public void dayDuLieu() {

        write(arrSanPham, NGUON);

    }

    public void keoDuLieu() {
        read(NGUON);
    }


}
