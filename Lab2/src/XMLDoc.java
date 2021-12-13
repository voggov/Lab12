import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class XMLDoc {
    public XMLDoc() throws XMLStreamException, IOException {
    }

    {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter("result.xml"));

        writer.writeStartDocument("1.0");
        writer.writeStartElement("BooksCataloge");

        for (int i = 0; i < 5;i++){
            writer.writeStartElement("Book");

            writer.writeStartElement("Number");
            writer.writeCharacters("Book" + i);
            writer.writeEndElement();

            writer.writeStartElement("Price");
            writer.writeCharacters("Book" + i*100);
            writer.writeEndElement();
            writer.writeEndElement();


        }
        writer.writeEndElement();
        writer.writeEndDocument();
        writer.flush();
    }


}
