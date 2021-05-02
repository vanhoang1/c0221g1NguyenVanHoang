package ss19_String_vs_regex.bai_tap.crawl_tin_tuc;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlNew {
    public static void main(String[] args) {
        try {
            URL url = new URL(" http://dantri.com.vn/the-gioi.htm ");
            // open the stream and put it into BufferedReade
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            // close scanner
            scanner.close();
            // remove all new line
            content = content.replaceAll("\\n+", "");
            // regex
            Pattern p = Pattern.compile("\">(.*?)\\<\\/a\\>\\<\\/h3\\>");
            Matcher m = p.matcher(content);
            while (m.find()) {
                System.out.println(m.group(0));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
