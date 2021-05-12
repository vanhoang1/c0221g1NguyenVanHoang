import java.util.*;
import java.util.Map.Entry;
/**
 * Sắp xếp theo Key
 */

public class HelloWorld {
    public static final String RegexVietNameseName = "^([\\s]*[A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*[\\s]+)+(([A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]*[\\s]*))*$";

    public static void main(String[] args) {

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("JDK 1.1.4", "Sparkler");
        map.put("J2SE 1.2", "Playground");
        map.put("J2SE 1.3", "Kestrel");
        map.put("J2SE 1.4", "Merlin");
        map.put("J2SE 5.0", "Tiger");
        map.put("Java SE 6", "Mustang");
        map.put("Java SE 7", "Dolphin");

        // Khởi tạo ra một Set entries
        Set<Entry<String, String>> entries = map.entrySet();

        System.out.println("----- Before sorting, random order -----");
        for (Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + " ==>> " + entry.getValue());
        }

        // Tạo custom Comparator
        Comparator<Entry<String, String>> comparator = new Comparator<Entry<String, String>>() {
            @Override
            public int compare(Entry<String, String> e1, Entry<String, String> e2) {
                String v1 = e1.getValue();
                String v2 = e2.getValue();
                return v1.compareTo(v2);
            }
        };

        // Convert Set thành List
        List<Entry<String, String>> listEntries = new ArrayList<>(entries);

        // Sắp xếp List
        Collections.sort(listEntries, comparator);

        // Tạo một LinkedHashMap và put các entry từ List đã sắp xếp sang
        LinkedHashMap<String, String> sortedMap = new LinkedHashMap<>(listEntries.size());
        for (Entry<String, String> entry : listEntries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        System.out.println("----- After sorting by values -----");
        Set<Entry<String, String>> sortedEntries = sortedMap.entrySet();
        for (Entry<String, String> mapping : sortedEntries) {
            System.out.println(mapping.getKey() + " ==>> " + mapping.getValue());
        }
    }


}


