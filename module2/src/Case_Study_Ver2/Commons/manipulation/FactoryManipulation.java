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
    public Transport search() {
        Scanner scanner= new Scanner(System.in);
        System.out.println("nhập biển số xe");
        String input= scanner.nextLine();
        setList(ReadWriteOto.read(getPath()));
        for (Transport transport :
                getList()) {
            if(transport.getLicensePlates().equals(input)) return transport;
        }
        return null;
    }
    protected List<String[]> listSanXuat() {
        return WriteRead.toListString(PathFactory.PATHHANGSANXUAT);
    }

}
