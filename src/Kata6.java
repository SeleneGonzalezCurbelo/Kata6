import java.io.IOException;
import java.util.List;
import javax.xml.bind.JAXBException;

import model.Meaning;
import model.Meanings;
import model.Phonetic;
import model.Phonetics;
import control.XMLWriter;
import control.JsonReader;

public class Kata6 {

    public static void main(String[] args) throws IOException, JAXBException {
        String  url = "https://api.dictionaryapi.dev/api/v2/entries/en/hello";
        
        List<Phonetic> phonetics = JsonReader.readJsonPhonetic(url);
        List<Meaning> meanings = JsonReader.readJsonMeaning(url);
                
        Phonetics phoneticsWrapper = new Phonetics(phonetics);
        Meanings meaningsWrapper = new Meanings(meanings);
        
        String xml = XMLWriter.toXML(phoneticsWrapper, meaningsWrapper);
        XMLWriter.writeXML(xml, "kata6.xml");
    }
}