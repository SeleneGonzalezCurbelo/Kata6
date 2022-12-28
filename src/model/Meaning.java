package model;

import java.util.Arrays;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "meaning")
public class Meaning {
    @XmlElement(name = "partOfSpeech")
    String partOfSpeech;
    @XmlElement(name = "synonyms")
    String[] synonyms;
    @XmlElement(name = "antonyms")
    String[] antonyms;
    @XmlElement(name = "definitions")
    Definition[] definitions;

    public Meaning() {
    }

    public Meaning(String partOfSpeech, String[] synonyms, String[] antonyms, Definition[] definitions) {
        this.partOfSpeech = partOfSpeech;
        this.synonyms = synonyms;
        this.antonyms = antonyms;
        this.definitions = definitions;
    }
    
    @Override
    public String toString() {
        return "Meaning{partOfSpeech=" + partOfSpeech + ", synonyms=" + Arrays.toString(synonyms) + ", antonyms=" + Arrays.toString(antonyms) + ", definition=" + Arrays.toString(definitions) + '}';
    }
}