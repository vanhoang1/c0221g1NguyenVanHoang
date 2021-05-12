package test_aa;

import Case_Study_Ver2.Models.Transport;

import javax.swing.*;
import java.util.Comparator;
import java.util.Scanner;

public  class Abc  {
    public static final String RegexVietNameseName = "^([\\s]*[A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*[\\s]+)+(([A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*[\\s]*))*$";
    public static String kiemTraNhapVaoTheoDinhDang(String thuocTinh, String regex, String tinNhan,String dinhDang) {
        String nhap = null;
        JOptionPane jOptionPane=new JOptionPane();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Nhập " + thuocTinh);
                nhap = scanner.nextLine();
                if (!nhap.matches(regex)) {
                    JOptionPane.showMessageDialog(jOptionPane,tinNhan,"Lỗi", JOptionPane.ERROR_MESSAGE);

                    throw new Exception("");
                }
                return nhap;
            } catch (Exception e) {
                System.err.println(tinNhan+"\nVui lòng nhập lại theo định dạng: "+dinhDang);
            }
        }
    }
    public static void nhap(){
        kiemTraNhapVaoTheoDinhDang("ten",RegexVietNameseName,"Nhập sai tên","chữ cái");
    }
}

