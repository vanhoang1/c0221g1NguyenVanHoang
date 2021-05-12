package Quan_ly_hoa_don.Commons;

import Case_Study_Ver2.Models.Transport;
import Quan_ly_hoa_don.Models.KhachHang;
import Quan_ly_hoa_don.Models.KhachHangNuocNgoai;
import Quan_ly_hoa_don.Models.KhachHangVietNam;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class WriteRead< E extends CsvToString> {
    private static String DAUPHAI = ",";

    public  void write(String path, List<E> csv) {
        File file = new File(path);
        try {

            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        FileWriter fileWriter = null;
        BufferedWriter writer = null;
        try {
            fileWriter = new FileWriter(file, false);
            writer = new BufferedWriter(fileWriter);
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
        try {
            for (E s :
                    csv) {
                assert writer != null;
                writer.append(s.toCsv());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                assert writer != null;
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static List<String[]> toListString(String path) {
        BufferedReader reader = null;
        File file = new File(path);
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        List<String[]> list = new ArrayList<>();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                list.add(line.split(DAUPHAI));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        return list;
    }
    public List<E> read(String path){
        List<E> list = new ArrayList<>();
        List<String[]> listString= toListString(path);
        for (String[] x :
                listString) {
           E e= conver(x);
            e.toObject(x);
            list.add(e);
        }
        return  list;
    }
    public abstract E conver(String[] x);
}
