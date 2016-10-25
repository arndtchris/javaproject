package javacesi;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.servlet.ServletContext;
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
    private ServletContext servletContext;

    public Parse()
    {

    }

    public ArrayList<Agence> parseAgence(String fullPathToFile) {

        File file = new File(fullPathToFile);
        ArrayList<AgenceXML> lesAgences = new ArrayList<>();
        ArrayList<Agence> agences = new ArrayList<Agence>();

        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(file);
            NodeList nodes = doc.getElementsByTagName("AgenceXML");

            JAXBContext jc = JAXBContext.newInstance(AgenceXML.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();

            for (int i = 0; i < nodes.getLength(); i++) {
                JAXBElement<AgenceXML> je = unmarshaller.unmarshal(nodes.item(i), AgenceXML.class);
                AgenceXML ag = je.getValue();
                lesAgences.add(ag);
            }

            for (AgenceXML agenceXML: lesAgences) {
                Agence agence = new Agence();
                agence.setAdresseEtab(agenceXML.Adresse);
                agence.setNomEtab(agenceXML.Nom);
                if(agenceXML.listeClient != null){
                    for(ClientBanqueXML clientXML : agenceXML.listeClient)
                    {
                        ClientBanque client = new ClientBanque();
                        client.setAdresse(clientXML.adresse);
                        client.setNom(clientXML.nom);
                        client.setPrenom(clientXML.prenom);
                        if(clientXML.Coffres != null){
                            for (CoffreXML coffreXML : clientXML.Coffres){
                                Coffre coffre = new Coffre();
                                coffre.setObjets(coffreXML.contenu);
                                coffre.setTypeCoffre(coffreXML.typeCoffre);
                                client.addCoffre(coffre);
                            }
                        }
                        agence.addClient(client);
                    }
                }
                agences.add(agence);
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

        return agences;
    }

    public ArrayList<FraisXML> parseFrais(String fullPathToFile)
    {

        File file = new File(fullPathToFile);

        ArrayList<FraisXML> lesOperations = new ArrayList<>();

        try
        {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(file);
            NodeList nodes = doc.getElementsByTagName("OperationXML");

            JAXBContext jc = JAXBContext.newInstance(FraisXML.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();

            for(int i = 0; i < nodes.getLength(); i++)
            {
                JAXBElement<FraisXML> je = unmarshaller.unmarshal(nodes.item(i), FraisXML.class);
                FraisXML op = je.getValue();
                lesOperations.add(op);
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

    public void parseCoffres() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Coffre.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Coffre coffre = (Coffre) jaxbUnmarshaller.unmarshal(new File("assets/coffres.xml"));

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
