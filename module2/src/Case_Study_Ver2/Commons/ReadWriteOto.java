package Case_Study_Ver2.Commons;

import Case_Study_Ver2.Models.Oto;
import Case_Study_Ver2.Models.Transport;

import java.util.ArrayList;
import java.util.List;

public class ReadWriteOto extends WriteRead  {
    public static List<Transport> read(String path) {
        List<Transport> listOto = new ArrayList<>();
        List<String[]> list= toListString(path);
        for (String[] x :
                list) {
                Transport transport = new Oto();
                transport.toObject(x);
                listOto.add(transport);
        }
        return  listOto;
    }
}
