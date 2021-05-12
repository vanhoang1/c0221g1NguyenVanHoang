package Quan_ly_hoa_don.Commons;

import Case_Study_Ver2.Models.Oto;
import Case_Study_Ver2.Models.Transport;
import Quan_ly_hoa_don.Models.KhachHang;
import Quan_ly_hoa_don.Models.KhachHangNuocNgoai;
import Quan_ly_hoa_don.Models.KhachHangVietNam;

import java.util.ArrayList;
import java.util.List;

public class WriteReadKhachHang extends WriteRead<KhachHang> {
    @Override
    public KhachHang conver(String[] x) {
        KhachHang khachHang;
        if(Validate.checkKHVN(x[0])){
            khachHang= new KhachHangVietNam();
        }else {
            khachHang= new KhachHangNuocNgoai();
        }
        return khachHang;
    }
}
