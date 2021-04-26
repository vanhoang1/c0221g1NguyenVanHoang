package Case_Study.Commons;

import Case_Study.models.Services;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WriteRead {
    private static String DAUPHAI=",";
    private static String XUONGDUONG="\n";
    public static void write(List<Services> list, String path){
        File file =new File(path);
        try {

            if(!file.exists()){
                file.createNewFile();
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        FileWriter fileWriter;
        BufferedWriter writer = null;
        try {
            fileWriter = new FileWriter(file);
            writer=new BufferedWriter(fileWriter);
        }catch (IOException e){
            System.out.println(e.getMessage());

        }
        try {
            for (Services s :
                    list) {
                assert writer != null;
                writer.append( s.csv());
                writer.append(DAUPHAI);
                writer.append(XUONGDUONG);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
       finally {
            try {
                assert writer != null;
                writer.flush();
                writer.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }

        }


    }
    public static List<List<String>> read(String path){
        BufferedReader reader=null;
        File file = new File(path);
        try {
            reader= new BufferedReader(new FileReader(file));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        List<List<String>> list= new ArrayList<>();
        String line;
        try {
            while ((line= reader.readLine())!=null){
                list.add(castObj(line));
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
       finally {
            try {
                reader.close();
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        return list;
    }
    public static List<String>  castObj(String line){
       List<String> list= new ArrayList<>();
        if (line != null) {
            list.addAll(Arrays.asList(line.split(DAUPHAI)));
        }
        return list;
    }
}
