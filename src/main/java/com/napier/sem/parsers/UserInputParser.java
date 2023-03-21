package com.napier.sem.parsers;

import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class UserInputParser {

    private static final String PATH_TO_REPORT_CONFIG = "/report_configuration.json";

    public Map<String, String> parseUserInput(){
        JSONParser parser = new JSONParser();
        Gson gson = new Gson();
        InputStream inputStream = JsonReader.class.getResourceAsStream(PATH_TO_REPORT_CONFIG);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        JsonObject jsonObject = gson.fromJson(inputStreamReader, JsonObject.class);

        // Create a Map<String, Integer> to store the key-value pairs from the JSON file

        // Iterate over the keys in the JSON object and add them to the Map as String-Integer pairs
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().getAsString();
            map.put(key, value);
        }

        return map;

    }
}
