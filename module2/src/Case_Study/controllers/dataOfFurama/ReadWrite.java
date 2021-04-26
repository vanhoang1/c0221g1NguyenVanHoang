package Case_Study.controllers.dataOfFurama;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

class ReadWrite<E> {

     private static final String DAUPHAI = ",";
    private static final String XUONGDONG = "\n";
     public ReadWrite() {
     }
    public void write(ArrayList<E> danhSach, String diaChi) {
        File file = new File(diaChi);//Tạo đối tượng file mới có địa chỉ truyền vào.

        if (!file.exists()) {//Nếu file đó chưa tồn tại.
            try {
                file.createNewFile();//Tạo ra file mới.
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        FileWriter k = null;
        try {
            //Khởi tạo đối tượng.
            k = new FileWriter(file);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        try {
            for (E x :
                    danhSach
            ) {
                assert k != null;
                k.append(String.valueOf(x));
                k.append(DAUPHAI);
                k.append(XUONGDONG);
            }


        } catch (IOException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (k != null) System.out.println("GHI FILE THANH CONG!");
                else System.out.println("GHI FILE THAT BAI");
                assert k != null;
                k.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
     public ArrayList<ArrayList<String>> read(String diaChi) {
         ArrayList< ArrayList<String> >  read  =new ArrayList<>();
         BufferedReader br = null;
         File file = new File(diaChi);
         try {
             String line;
             br = new BufferedReader(new FileReader(file));

             while ((line = br.readLine()) != null) {
               read.add(  chuyenFile(line));
             }
             return read;
         } catch (IOException e) {
             e.printStackTrace();
         } catch (Exception e) {
             System.err.println(e);
         } finally {
             try {
                 if (br != null) System.out.println("DOC FILE THANH CONG!");
                 else System.out.println("DOC FILE THAT BAI");

                 br.close();
             } catch (IOException crunchifyException) {
                 crunchifyException.printStackTrace();
             }

         }


         return read;
     }
     public ArrayList<String> chuyenFile(String fileText) {
         ArrayList<String> arrayList = new ArrayList<>();
         if (fileText != null) {
             String[] splitData = fileText.split(DAUPHAI);
             arrayList.addAll(Arrays.asList(splitData));
         }
         return arrayList;
     }
}
