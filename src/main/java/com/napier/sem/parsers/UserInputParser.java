package com.napier.sem.parsers;

import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Turns the report configuration json file into a map of string : string
 */
public class UserInputParser implements IUserInputParser{

    /**
     * Parses a json file containing user inputs into a map
     * @param path path to the json file
     * @return a mapped version of the json files content
     */
    public Map<String, String> parseUserInput(String path){
        JsonObject jsonContents = readJsonFile(path);

        // Iterate over the keys in the JSON object and add them to the Map as String-Integer pairs
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<String, JsonElement> entry : jsonContents.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().getAsString();
            map.put(key, value);
        }

        return map;

    }

    /**
     * reads the json file into a JsonObject
     * @param pathToReportConfig path to the json file
     * @return a JsonObject
     */
    private JsonObject readJsonFile(String pathToReportConfig){
        Gson gson = new Gson();
        InputStream inputStream = JsonReader.class.getResourceAsStream(pathToReportConfig);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

        return gson.fromJson(inputStreamReader, JsonObject.class);
    }
}
