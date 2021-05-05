package Case_Study_Ver2.Commons.manipulation;

import Case_Study_Ver2.Commons.ReadWriteOto;
import Case_Study_Ver2.Commons.ReadWriteTruck;
import Case_Study_Ver2.Commons.Validate;
import Case_Study_Ver2.Models.Transport;
import Case_Study_Ver2.Models.Truck;
import Case_Study_Ver2.data.PathFactory;

import java.util.Scanner;

public class TruckManipulation extends FactoryManipulation {
    static Scanner scanner = new Scanner(System.in);

    public TruckManipulation() {
        setPath(PathFactory.PATHTRUCK);
    }
    @Override
    public void show() {
        setList(ReadWriteTruck.read(getPath()));
        for (Transport t :
                getList()) {
            System.out.println(t.toString());
        }
    }

    @Override
    public void add() {
        setList(ReadWriteTruck.read(getPath()));
        Truck truck= new Truck();
        String input;
        while (true) {
            try {
                System.out.println(" nhập biển số xe :");
                input = scanner.nextLine();
                if (!Validate.CheckBienXeTai(input)) {
                    throw new Exception("bien xe phai dúng dinh dang");
                }
                if(search(input)>=0){
                    throw  new Exception("biển bị trùng");
                }
                truck.setLicensePlates(input);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        thongTinChung(truck);
        while (true) {
            try {
                System.out.println(" nhập tải trọng:");
                input = scanner.nextLine();
                if (!Validate.CheckNumBer(input, 1, 33)) {
                    throw new Exception("nhập số");
                }
                truck.setLimitLoad(Integer.parseInt(input));
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        getList().add(truck);
        ReadWriteTruck.write(getPath(), getList());
    }

    @Override
    public Transport edit(Transport transport) {
        return null;
    }
    public int search(String bxe) {
        setList(ReadWriteTruck.read(getPath()));
        return super.search(bxe);
    }
}
