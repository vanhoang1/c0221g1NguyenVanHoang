package ss17_Biary_Serializa.bai_tap;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadWrite<E> {
    public  void write(ArrayList<E> danhSach, String diaChi) throws IOException {
        File file = new File(diaChi);//Tạo đối tượng file mới có địa chỉ truyền vào.

        if (!file.exists()) {//Nếu file đó chưa tồn tại.
            try {
                file.createNewFile();//Tạo ra file mới.
            } catch (IOException e) {
                System.out.println(e);
            }

        }
        FileWriter k=null;
        try {
            //Khởi tạo đối tượng.
            k=new FileWriter(file);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        } finally {

            try {

                for (E x:
                        danhSach
                     ) {

                    k.write(x.toString());
                }
                k.close();


            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    public  Object read(String diaChi){
        //Khai báo đối tượng FileInputStream và ObjectInputStream trỏ tới null

        Object read = null;
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(diaChi));
            return read= new String(encoded);
        } catch (Exception e) {
            System.err.println(e);
        }finally {if (read != null)
            System.out.println("DOC FILE THANH CONG!");
        else System.out.println("DOC FILE THAT BAI");

        }

        return null;
    }

}
