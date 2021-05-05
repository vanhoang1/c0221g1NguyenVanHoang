package Case_Study_Ver2.Commons.manipulation;

import Case_Study_Ver2.Commons.ReadWriteOto;
import Case_Study_Ver2.Commons.Validate;
import Case_Study_Ver2.Commons.WriteRead;
import Case_Study_Ver2.Models.Transport;
import Case_Study_Ver2.data.PathFactory;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public abstract class FactoryManipulation implements Manipulation<Transport> {
    private List<Transport> list;
    private String path;

    public FactoryManipulation() {
        list = new ArrayList<>();
    }

    public List<Transport> getList() {
        return list;
    }

    public void setList(List<Transport> list) {
        this.list = list;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public abstract void show();
    protected void thongTinChung(Transport transport){
        Scanner scanner = new Scanner(System.in);
        String input;
        while (true) {
            try {
                System.out.println("chọn hãng sản xuất :");
                for (String[] x :
                        listSanXuat()) {
                    System.out.println(Arrays.toString(x));
                }
                input = scanner.nextLine();
                if (!Validate.CheckNumBer(input, 1, listSanXuat().size())) {
                    throw new Exception("nhập từ 1 đến " + listSanXuat().size());
                }
                String[] name = listSanXuat().get(Integer.parseInt(input) - 1);
                transport.setManufacturerName(name[1]);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true) {
            try {
                System.out.println("nhập năm sản xuất :");
                input = scanner.nextLine();
                if (!Validate.CheckNumBer(input,0,2000)) {
                    throw new Exception("nhập số");
                }
                transport.setYearOfManufacture(Integer.parseInt(input));
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        while (true) {
            try {
                System.out.println("nhập chủ sở hữu:");
                input = scanner.nextLine();
                transport.setOwner(input);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public int search(String bxe ) {
        for (Transport l :
                getList()) {
            if (l.getLicensePlates().equals(bxe)) return getList().indexOf(l);
        }
        return -1;
    }
    protected List<String[]> listSanXuat() {
        return WriteRead.toListString(PathFactory.PATHHANGSANXUAT);
    }
    @Override
    public void del(int index) {
        getList().remove(index);
        WriteRead.write(getPath(), getList());
    }
    public void choicedel( int index ) {
        System.out.println("bạn chọn xóa" + '\n' + getList().get(index).toString() + '\n' +
                "1.Yes" + '\n' +
                "2.No");
        int choice;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice != 2 && choice != 1) {
                    throw new Exception("chỉ chọn 1 hoặc 2 ");
                }
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(choice==1){
            del(index);

        }

    }
}
