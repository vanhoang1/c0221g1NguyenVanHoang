package ss16_IO_textFile.doc_ghi_file_van_ban.bai_tap;

import java.io.*;

public class Copyfile {
    public static void main(String[] args) {
        try {

            CheckFile nguon= new CheckFile("nguồn");
            nguon.link( "D:\\C0221G1_NguyenVanHoang\\module2\\src\\ss16_IO_textFile\\doc_ghi_file_van_ban\\bai_tap\\text");
            FileReader reader= new FileReader(nguon.check);
            BufferedReader read=new BufferedReader(reader);
            CheckFile dich= new CheckFile("đích");
            dich.link("D:\\C0221G1_NguyenVanHoang\\module2\\src\\ss16_IO_textFile\\doc_ghi_file_van_ban\\bai_tap\\newText");
            FileWriter writer= new FileWriter(dich.check);
            String line= null;
            while ((line=read.readLine())!=null){
                writer.write(line);
            }
            writer.close();
            read.close();
        } catch (Exception e){
            System.err.println(e.getMessage());;
        }
    }
    public static class CheckFile {
        String name;
        File check;
        public void link(String link) throws FileNotFoundException {

            File a= new File(link);
            if(!a.exists())
                throw new FileNotFoundException("Đường dẫn "+name+" không tồn tại");
            else
            this.check=a;
        }

        public CheckFile(String s) {
            this.name=s;
        }


    }
}
