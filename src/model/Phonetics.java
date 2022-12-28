package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "phonetics")
public class Phonetics {
    private List<Phonetic> phonetic;

    public Phonetics() {
    }

    public Phonetics(List<Phonetic> phonetic) {
        this.phonetic = phonetic;
    }

    @XmlElement(name = "phonetic")
    public List<Phonetic> getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(List<Phonetic> phonetic) {
        this.phonetic = phonetic;
    }
}