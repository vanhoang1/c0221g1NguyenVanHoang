package Quan_ly_hoa_don.Controllers;

import Quan_ly_hoa_don.Commons.WriteReadKhachHang;
import Quan_ly_hoa_don.Data.Path;
import Quan_ly_hoa_don.Models.KhachHang;
import Quan_ly_hoa_don.Models.KhachHangNuocNgoai;
import Quan_ly_hoa_don.Models.KhachHangVietNam;

import java.util.ArrayList;
import java.util.List;

public class QuanLyKhachHang extends QuanLyChung<KhachHang> implements ThaoTac<KhachHang>{
    WriteReadKhachHang writeReadKhachHang= new WriteReadKhachHang();
    public QuanLyKhachHang() {
      this.writeRead= writeReadKhachHang;
      this.path=Path.PATHKHACHHANG;
    }

    @Override
    public List<KhachHang> pullList() {
        return writeRead.read(getPath());
    }

    @Override
    public void pushList() {
        writeRead.write(getPath(),getList());
    }

    @Override
    public String getPath() {
       return this.path;
    }

    @Override
    public void add(int index) {
        KhachHang khachHang = null;
        try{
            switch (index){
                case 1:
                {
                    setList(pullList());
                    khachHang= new KhachHangVietNam("KHVN-00002","Nguyễn Quang Hải","Kinh doanh",200);
                    break;
                } case 2:
                {
                    setList(pullList());
                    khachHang= new KhachHangNuocNgoai("KHNN-00001","Cristiano Ronaldo", "Portugal");
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + index);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        getList().add(khachHang);
        pushList();
    }

    @Override
    public KhachHang edit(KhachHang khachHang) {
        return null;
    }

    @Override
    public void del(int index) {

    }

    @Override
    public KhachHang search(String value) {
        return null;
    }

    @Override
    public void show() {

        for (KhachHang l :
                getList()) {
            System.out.println( l.toString());
        }
    }
}
