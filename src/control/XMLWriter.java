package control;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import model.Meaning;
import model.Meanings;
import model.Phonetics;

public class XMLWriter {
    public static void writeXML(String xml, String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write(xml);
            writer.close();
        }
    }
    
    public static String toXML(Phonetics phoneticsWrapper, Meanings meaningsWrapper) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Phonetics.class, Meaning.class, Meanings.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter sw = new StringWriter();
        marshaller.marshal(phoneticsWrapper, sw);
        marshaller.marshal(phoneticsWrapper, System.out);

        marshaller.marshal(meaningsWrapper, sw);
        marshaller.marshal(meaningsWrapper, System.out);

        return sw.toString();
    }
}