package model.control;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.joining;

import model.Meaning;
import model.Phonetic;

public class jsonReader {
    
    public static List<Phonetic> readJsonPhonetic(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        if (connection.getResponseCode() != 200) {
          throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
        }
        connection.disconnect();
        
        Gson gson = new Gson();

        JsonArray jsonArrayPhonetics = gson.fromJson(read(url), JsonArray.class)
                .get(0).getAsJsonObject()
                .get("phonetics").getAsJsonArray();
        
        List<Phonetic> phonetics = new ArrayList<>();
        for (int i = 0; i < jsonArrayPhonetics.size(); i++) {
            JsonObject jsonObject = jsonArrayPhonetics.get(i).getAsJsonObject();
            Phonetic phonetic = gson.fromJson(jsonObject, Phonetic.class);
            phonetics.add(phonetic);
        } 
        return phonetics;
    }
    
    public static List<Meaning> readJsonMeaning(String urlString) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        if (connection.getResponseCode() != 200) {
          throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
        }
        connection.disconnect();
        
        Gson gson = new Gson();
        
        JsonArray jsonArrayMeanings = gson.fromJson(read(url), JsonArray.class)
                .get(0).getAsJsonObject()
                .get("meanings").getAsJsonArray();

        List<Meaning> meanings = new ArrayList<>();
        for (int i = 0; i < jsonArrayMeanings.size(); i++) {
            JsonObject jsonObject = jsonArrayMeanings.get(i).getAsJsonObject();
            Meaning meaning = gson.fromJson(jsonObject, Meaning.class);
            meanings.add(meaning);
        } 
        return meanings;
}
    
    private static String read(URL url) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return reader.lines().collect(joining());
        }      
    }
}