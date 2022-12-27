package model;

import com.google.gson.annotations.SerializedName;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Phonetic {
    @SerializedName(value = "Phonetic") 
    public String text;
    public String audio;
    public String sourceURL;
    public License license;
    
    @Override
    public String toString() {
        return "Phonetic{text=" + text + ", audio=" + audio + ", sourceURL=" + sourceURL + ", license=" + license + '}';
    }
    
    public static class License {
        @XmlAttribute
        public String name;
        @XmlAttribute
        public String url;
    }
}