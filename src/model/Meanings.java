package model;

import java.io.StringWriter;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "meanings")
public class Meanings {
    private List<Meaning> meaning;
    
    public Meanings() {
    }

    public Meanings(List<Meaning> meaning) {
        this.meaning = meaning;
    }

    @XmlElement(name = "meaning")
    public List<Meaning> getMeaning() {
        return meaning;
    }

    public void setPhonetic(List<Meaning> meaning) {
        this.meaning = meaning;
    }

    public String toXML() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Meanings.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter sw = new StringWriter();
        marshaller.marshal(this, sw);
        marshaller.marshal(this, System.out);
        return sw.toString();
    }
}