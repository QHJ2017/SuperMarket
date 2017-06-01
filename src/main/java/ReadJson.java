package main.java;

import json.JSONArray;

/**
 * Created by ArtistQiu on 2017/6/1.
 */
public class ReadJson {
    public static String[] ReadJsonArray(JSONArray jsonArray) {
        String[] strings = new String[jsonArray.length()];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = jsonArray.get(i).toString();
        }
        return strings;
    }
}
