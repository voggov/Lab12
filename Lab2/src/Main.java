import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, XMLStreamException {

        XMLDoc doc = new XMLDoc();
        String name = "result.xml";
        String fileName = "temp.json";
        try {
            File file = new File(name);
            InputStream inputStream = new FileInputStream(file);
            StringBuilder builder = new StringBuilder();
            int ptr = 0;
            while ((ptr = inputStream.read()) != -1) {
                builder.append((char) ptr);

            }

            String xml = builder.toString();
            JSONObject jsonObj = XML.toJSONObject(xml);

            FileWriter fileWriter = new FileWriter(fileName);


            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < jsonObj.toString().split(",").length; i++) {
                System.out.println(jsonObj.toString().split(",")[i]);
                bufferedWriter.write(jsonObj.toString().split(",")[i]);
                bufferedWriter.write("\n");
            }

            bufferedWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

