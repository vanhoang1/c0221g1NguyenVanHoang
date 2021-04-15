package ss17_Biary_Serializa.bai_tap;

public class Main {
    public static void main(String[] args) {
        QuanLySanPham quanLySanPham= new QuanLySanPham();
        quanLySanPham.add(1,"abc","gg",2333d);
        quanLySanPham.add(2,"abc","gg",2333d);
        quanLySanPham.add(3,"abc","gg",2333d);
        quanLySanPham.dayDuLieu();
        quanLySanPham.keoDuLieu();
    }
}
