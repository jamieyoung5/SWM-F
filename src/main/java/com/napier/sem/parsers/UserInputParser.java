package com.napier.sem.parsers;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class UserInputParser {

    private static final String PATH_TO_REPORT_CONFIG = "report_configuration.json";

    public Map<String, String> parseUserInput(){
        JSONParser parser = new JSONParser();
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            Object obj = parser.parse(Arrays.toString(classloader.getResourceAsStream(PATH_TO_REPORT_CONFIG).readAllBytes()));
            JSONObject jsonObject = (JSONObject) obj;

            // Create a Map<String, Integer> to store the key-value pairs from the JSON file
            Map<String, String> map = new HashMap<>();

            // Iterate over the keys in the JSON object and add them to the Map as String-Integer pairs
            for (Object key : jsonObject.keySet()) {
                String property = (String) key;
                int value = ((Long) jsonObject.get(key)).intValue();
                map.put(property, Integer.toString(value));
            }

            System.out.println(map);
            return map;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Was not able to parse the report config");
        }

    }
}
