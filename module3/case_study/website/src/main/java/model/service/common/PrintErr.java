package model.service.common;

import java.util.Map;

public class PrintErr {
    public static  String printErr(Map<String,String> map) {
        StringBuilder err = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            err.append(entry.getValue()).append("<br>");
        }
        map.clear();
        return String.valueOf(err);
    }
}
