package com.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class DictionaryService implements IDictionaryService {
    static Map<String,String> map = new HashMap<>();
    static {
        map.put("banana","chuối");
        map.put("cat","mèo");
        map.put("dog","chó");
    }
    @Override
    public String getMeaning(String key) {
        return map.get(key)!=null?map.get(key):"the word you entered is not in the dictionary";
    }
}
