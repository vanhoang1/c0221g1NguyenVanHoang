package ss17_Biary_Serializa.bai_tap;

import java.io.*;
import java.util.ArrayList;


public class ReadWrite<E> {
    private static final String DAUPHAI = ",";
    private static final String XUONGDONG = "\n";

    public void write(ArrayList<E> danhSach, String diaChi) {
        File file = new File(diaChi);//Tạo đối tượng file mới có địa chỉ truyền vào.

        if (!file.exists()) {//Nếu file đó chưa tồn tại.
            try {
                file.createNewFile();//Tạo ra file mới.
            } catch (IOException e) {
                System.out.println(e);
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
                k.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public ArrayList<ArrayList<String>> read(String diaChi) {
        Object read = null;
        BufferedReader br = null;
        File file = new File(diaChi);
        try {
            String line;
            br = new BufferedReader(new FileReader(file));

            while ((line = br.readLine()) != null) {
                inSp(chuyenFile(line));
            }

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

        return null;
    }

    public ArrayList<SanPham> chuyenFile(String fileText) {
        ArrayList<SanPham> arrayList = new ArrayList<>();
        if (fileText != null) {
            String[] splitData = fileText.split(DAUPHAI);
            for (int i = 0; i < splitData.length; i += 4) {
                SanPham k = new SanPham(splitData[i], splitData[i + 1], splitData[i + 2], splitData[i + 3]);
                arrayList.add(k);
            }
        }
        return arrayList;
    }

    public void inSp(ArrayList<SanPham> arrayList) {
        for (SanPham x :
                arrayList) {
            System.out.printf("[ MaSanPham : %s TenSanPham : %s Hang :%s Gia : %s ]", x.getMaSanPham(), x.getTanSanPham(), x.getHangSanPham(), x.getGia());
            System.out.println();
        }

    }

}
