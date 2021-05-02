package Case_Study_Ver2.Commons.manipulation;

import Case_Study_Ver2.Commons.ReadWriteOto;
import Case_Study_Ver2.Commons.Validate;
import Case_Study_Ver2.Models.Oto;
import Case_Study_Ver2.Models.Transport;
import Case_Study_Ver2.data.PathFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OtoManipulation extends FactoryManipulation {
    static Scanner scanner = new Scanner(System.in);

    public OtoManipulation() {
        setPath(PathFactory.PATHOTO);
    }

    @Override
    public void show() {

    }

    @Override
    public void add() {
        setList(ReadWriteOto.read(getPath()));
        Oto oto = new Oto();
        String input;
        while (true) {
            try {
                System.out.println(" nhập biển số xe :");
                input = scanner.nextLine();
                if (!Validate.CheckBienXeOto(input)) {
                    throw new Exception("bien xe phai dúng dinh dang");
                }
                oto.setLicensePlates(input);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        thongTinChung(oto);
        input = (oto.getLicensePlates().contains("A"))?"xe du lịch":"xe khách";
        oto.setVehicleModel(input);
        while (true) {
            try {
                System.out.println(" nhập số chổ :");
                input = scanner.nextLine();
                if (!Validate.CheckNumBer(input,1,33)) {
                    throw new Exception("nhập số");
                }
                oto.setNumberOfSeats(Integer.parseInt(input));
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        getList().add(oto);
        ReadWriteOto.write(getPath(), getList());

    }

    @Override
    public Transport edit(Transport transport) {
        return null;
    }

    @Override
    public void del() {

    }
}
