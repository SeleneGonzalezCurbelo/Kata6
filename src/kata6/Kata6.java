package kata6;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import static java.util.stream.Collectors.joining;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import model.Phonetic;

public class Kata6 {

    public static void main(String[] args) throws MalformedURLException, IOException, JAXBException { 
        
        URL url = new URL("https://api.dictionaryapi.dev/api/v2/entries/en/hello"); 
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");

        if (connection.getResponseCode() != 200) {
          throw new RuntimeException("Failed : HTTP error code : " + connection.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((connection.getInputStream())));

        String output;
        String jsonString = null;        
        while ((output = br.readLine()) != null) {
            jsonString = output;
        }
        
        connection.disconnect();
        
        Gson gson = new Gson();
        
        JsonObject jsonObjectPhonetic = gson.fromJson(read(url), JsonArray.class)
                .get(0).getAsJsonObject()
                .get("phonetics").getAsJsonArray()
                .get(1).getAsJsonObject(); 
        
        Phonetic phonetic = gson.fromJson(jsonObjectPhonetic, Phonetic.class);

        JAXBContext context = JAXBContext.newInstance(Phonetic.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(phonetic, System.out);
        marshaller.marshal(phonetic, new File("kata6.xml"));
        
    }

    private static String read(URL url) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return reader.lines().collect(joining());
        }      
    }
}