package Case_Study_Ver2.Commons;
import Case_Study_Ver2.Models.Transport;
import Case_Study_Ver2.Models.Truck;


import java.util.ArrayList;
import java.util.List;

public class ReadWriteTruck extends WriteRead {
    public static List<Transport> read(String path) {
        List<Transport> listTruck = new ArrayList<>();
        List<String[]> list= toListString(path);
        for (String[] x :
                list) {
            Transport transport = new Truck();
            transport.toObject(x);
            listTruck.add(transport);
        }

        return  listTruck;
    }
}
