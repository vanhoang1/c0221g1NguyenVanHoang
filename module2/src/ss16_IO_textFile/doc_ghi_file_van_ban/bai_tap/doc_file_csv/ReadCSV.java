package ss16_IO_textFile.doc_ghi_file_van_ban.bai_tap.doc_file_csv;
import java.io.*;
public class ReadCSV {
    public static void main(String[] args) {
        String line;
        try (BufferedReader br = new BufferedReader(
                new FileReader("D:\\C0221G1_NguyenVanHoang\\module2\\src\\ss16_IO_textFile\\doc_ghi_file_van_ban\\bai_tap\\doc_file_csv\\quoc_gia.csv"))) {

            while ((line = br.readLine()) != null) {

                // split by a comma separator
                String[] split = line.split(",");
                System.out.println("\nLength : " + split.length);
                System.out.println("split[0] : " + split[0]);
                System.out.println("split[1] : " + split[1]);
                System.out.println("split[2] : " + split[2]);
                System.out.println("split[3] : " + split[3]);
                System.out.println("split[4] : " + split[4]);
                System.out.println("split[5] : " + split[5]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
