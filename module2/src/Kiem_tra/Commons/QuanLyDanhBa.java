package Kiem_tra.Commons;
import Kiem_tra.Data.Path;
import Kiem_tra.Models.DanhBa;
import hang_chua.QuanLyChung.QuanLyChung;
import hang_chua.WriteRead.WriteRead;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuanLyDanhBa extends QuanLyChung<DanhBa> {
    @Override
    public WriteRead<DanhBa> chonDocGhi() {
        return new WriteReadDanhBa(Path.PATHDANHBA);
    }

    @Override
    public void them() {
        setList(pullList());
        Scanner scanner = new Scanner(System.in);
        DanhBa danhBa = new DanhBa();
        String input;
        while (true) {
            try {
                System.out.println(" nhập so dien thoai :");
                input = scanner.nextLine();
                if (!Validate.CheckPhone(input)) {
                    throw new Exception("so dt phai dung dinh dang XXXXXXXXXX");
                }
                danhBa.setSDT(input);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        suaThongTin(danhBa);
        getList().add(danhBa);
        pushList();
    }

    public void suaThongTin(DanhBa danhBa) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            try {
                System.out.println(" chọn nhóm danh ba :");
                WriteReadNhomDB writeReadNhomDB = new WriteReadNhomDB(Path.PATHNHOMDANHBA);
                List<String[]> list=writeReadNhomDB.toListString();
                input = scanner.nextLine();
                int index=Integer.parseInt(input)-1;
                if (index> list.size()||index<0) {
                    throw new Exception("chỉ chon trog danh ba");
                }
                danhBa.setNhomDanhba(Arrays.toString(list.get(Integer.parseInt(input))));
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("nhap ho ten");
        String ten = scanner.nextLine();
        danhBa.setHoTen(ten);
        System.out.println("nhap gioi tinh");
        String gioiTinh = scanner.nextLine();
        danhBa.setGioiTinh(gioiTinh);
        System.out.println("nhap dia chi");
        String diaChi = scanner.nextLine();
        danhBa.setDiaChi(diaChi);
        System.out.println("nhap ngay sinh");
        String ngaySinh = scanner.nextLine();
        danhBa.setNgaySinh(ngaySinh);
        while (true) {
            try {
                System.out.println(" nhập Email:");
                input = scanner.nextLine();
                if (!Validate.CheckEmail(input)) {
                    throw new Exception(" email phai dung X@XXXX.XXX");
                }
                danhBa.setEmail(input);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    protected boolean dieuKienTimKiem(DanhBa danhBa, String input) {
        return danhBa.getSDT().equals(input);
    }

    public void timGanDung() {
        setList(pullList());
        System.out.println(getList().get(timKiem()).toString());
    }
}
