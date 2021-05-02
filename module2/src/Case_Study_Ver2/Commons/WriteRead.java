package Case_Study_Ver2.Commons;

import Case_Study.models.Services;
import Case_Study_Ver2.Models.Transport;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class WriteRead {
    private static String DAUPHAI = ",";
    private static String XUONGDUONG = "\n";

    public static void write(String path, List<Transport> csv) {
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
            for (Transport s :
                    csv) {
                assert writer != null;
                writer.append(s.toCsv());
                writer.append(DAUPHAI);
                writer.append(XUONGDUONG);
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

}
