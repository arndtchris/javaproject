package javacesi;

import com.sun.deploy.util.SessionState;
import jdk.internal.org.xml.sax.InputSource;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.bind.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by chris on 04/10/2016.
 */
public class Parse {
    public Parse()
    {

    }


    public ArrayList<OperationXML> parseOperation()
    {
        File file = new File("assets/Cataloguefrais2016.xml");

        ArrayList<OperationXML> lesOperations = new ArrayList<>();

        try
        {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(file);
            NodeList nodes = doc.getElementsByTagName("OperationXML");

            JAXBContext jc = JAXBContext.newInstance(OperationXML.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();

            for(int i = 0; i < nodes.getLength(); i++)
            {
                JAXBElement<OperationXML> je = unmarshaller.unmarshal(nodes.item(i), OperationXML.class);
                OperationXML ope = je.getValue();
                lesOperations.add(ope);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return lesOperations;
    }

    public void operationsToXML(ArrayList<OperationXML> lesOperations) {
        try {
            OperationXMLs operas = new OperationXMLs();
            JAXBContext jc2 = JAXBContext.newInstance(OperationXMLs.class);
            Marshaller marshaller = jc2.createMarshaller();

            //Constitu un fichier contenant autant de noeuds que d'objets contenu dans operas
            operas.operations = lesOperations;
            marshaller.marshal(operas, new File("assets/lesOperations.xml"));


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /*private static void jaxbObjectToXML(OperationXML emp, int i) {

        try {
            JAXBContext context = JAXBContext.newInstance(OperationXML.class);
            Marshaller m = context.createMarshaller();
            //for pretty-print XML in JAXB
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Write to System.out for debugging
            // m.marshal(emp, System.out);

            // Write to File
            m.marshal(emp, new File("assets/Operation"+i+".xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }*/
}
