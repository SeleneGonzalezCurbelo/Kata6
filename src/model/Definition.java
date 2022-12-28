package model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "definitions")
public class Definition {
    private String definition;
    private String[] synonyms;
    private String[] antonyms;

    public Definition() {
    }

    public Definition(String definition, String[] synonyms, String[] antonyms) {
        this.definition = definition;
        this.synonyms = synonyms;
        this.antonyms = antonyms;
    }

    @XmlElement(name = "definition")
    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    @XmlElement(name = "synonyms")
    public String[] getSynonyms() {
        return synonyms;
    }
    
    public void setSynonyms(String[] synonyms) {
        this.synonyms = synonyms;
    }

    @XmlElement(name = "antonyms")
    public String[] getAntonyms() {
        return antonyms;
    }

    public void setAntonyms(String[] antonyms) {
        this.antonyms = antonyms;
    }
}