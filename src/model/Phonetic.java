package model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "phonetic")
public class Phonetic {
    @XmlElement(name = "text")
    public String text;
    @XmlElement(name = "audio")
    public String audio;
    @XmlElement(name = "sourceUrl")
    public String sourceUrl;
    @XmlElement(name = "license")
    public License license;

    public Phonetic(String text, String audio, String sourceUrl, License license) {
        this.text = text;
        this.audio = audio;
        this.sourceUrl = sourceUrl;
        this.license = license;
    }

    public Phonetic() {
    }
    
    @Override
    public String toString() {
        return "Phonetic{text=" + text + ", audio=" + audio + ", sourceUrl=" + sourceUrl + ", license=" + license + '}';
    }
    
    @XmlRootElement(name = "license")
    public static class License {
        @XmlElement(name = "name")
        public String name;
        @XmlElement(name = "url")
        public String url;

        public License(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public License() {
        }
    }
    
    @XmlRootElement(name = "phonetics")
    public static class Phonetics {
        @XmlElement(name = "phonetic")
        private List<Phonetic> phonetics;

        public Phonetics(List<Phonetic> phonetics) {
            this.phonetics = phonetics;
        }

        public Phonetics() {
            this.phonetics = new ArrayList<>();
        }
    }
}