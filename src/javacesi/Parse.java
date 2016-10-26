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
import java.util.Iterator;

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
                agence.setIdAgence(agenceXML.idAgence);
                agence.setAdresseEtab(agenceXML.Adresse);
                agence.setNomEtab(agenceXML.Nom);
                if(agenceXML.listeClient != null){
                    for(ClientBanqueXML clientXML : agenceXML.listeClient)
                    {
                        ClientBanque client = new ClientBanque();
                        client.setIdClient(Integer.parseInt(clientXML.idClient));
                        client.setAdresse(clientXML.adresse);
                        client.setNom(clientXML.nom);
                        client.setPrenom(clientXML.prenom);
                        if(clientXML.Coffres != null){
                            for (CoffreXML coffreXML : clientXML.Coffres){
                                Coffre coffre = new Coffre();
                                coffre.setIdCoffre(Integer.parseInt(coffreXML.idCoffre));
                                coffre.setContenu(coffreXML.contenu);
                                coffre.setTypeCoffre(coffreXML.typeCoffre);
                                coffre.setPiece(coffreXML.piece);
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

    public ArrayList<Agence> ajouteCoffreAClient(String fullPathToFile, String clientID, CoffreXML coffreToAdd)
    {
        File file = new File(fullPathToFile);
        ClientBanque clientToReturn = new ClientBanque();

        ArrayList<AgenceXML> lesAgences = new ArrayList<>();
        //ArrayList<Agence> agences = new ArrayList<Agence>();

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
                if(agenceXML.listeClient != null){
                    for(ClientBanqueXML clientXML : agenceXML.listeClient)
                    {
                        if(clientXML.idClient.equals(clientID))
                        {

                                if(coffreToAdd.idCoffre != "" && coffreToAdd.idCoffre != null)
                                {
                                     for(CoffreXML coffre : clientXML.Coffres)
                                    {
                                        if(coffre.idCoffre.equals(coffreToAdd.idCoffre))
                                        {
                                            coffre.contenu = coffreToAdd.contenu;
                                            coffre.dateFermeture = coffreToAdd.dateFermeture;
                                            coffre.dateOuverture = coffreToAdd.dateOuverture;
                                            coffre.piece = coffreToAdd.piece;
                                            coffre.typeCoffre  =coffreToAdd.typeCoffre;
                                        }
                                    }
                                }else {
                                    coffreToAdd.idCoffre = nextCoffreID(fullPathToFile).toString();
                                    if(clientXML.Coffres == null)
                                    {
                                        clientXML.Coffres = new ArrayList<CoffreXML>();
                                    }

                                    clientXML.Coffres.add(coffreToAdd);
                                }
                        }
                    }
                }
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

        try {
            AgencesXML agences = new AgencesXML();
            JAXBContext jc2 = JAXBContext.newInstance(AgencesXML.class);
            Marshaller marshaller = jc2.createMarshaller();

            agences.agences = lesAgences;
            marshaller.marshal(agences, new File(fullPathToFile));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return parseAgence(fullPathToFile);

    }

    private Integer nextCoffreID(String fullPathToFile)
    {
        File file = new File(fullPathToFile);
        ArrayList<AgenceXML> lesAgences = new ArrayList<>();
        Integer nextID = 0;

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
                agence.setIdAgence(agenceXML.idAgence);
                agence.setAdresseEtab(agenceXML.Adresse);
                agence.setNomEtab(agenceXML.Nom);
                if(agenceXML.listeClient != null){
                    for(ClientBanqueXML clientXML : agenceXML.listeClient)
                    {
                        if(clientXML.Coffres != null){
                            for (CoffreXML coffreXML : clientXML.Coffres){

                                if(nextID < Integer.parseInt(coffreXML.idCoffre))
                                {
                                    nextID = Integer.parseInt(coffreXML.idCoffre);
                                }
                            }
                        }
                    }
                }
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

        return nextID + 1;
    }

    public ArrayList<Coffre> coffreBySelonClientID(String fullPathToFile, String clientID)
    {
        File file = new File(fullPathToFile);
        ArrayList<AgenceXML> lesAgences = new ArrayList<>();

        ArrayList<Coffre> lesCoffresDuClient = new ArrayList<>();

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
                if(agenceXML.listeClient != null){
                    for(ClientBanqueXML clientXML : agenceXML.listeClient)
                    {
                        if(clientXML.idClient.equals(clientID))
                        {
                            if(clientXML.Coffres != null){
                                for (CoffreXML coffreXML : clientXML.Coffres){
                                    lesCoffresDuClient.add(new Coffre(coffreXML));
                                }
                            }
                        }

                    }
                }
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

        return lesCoffresDuClient;
    }

    public ArrayList<FraisXML> insertFrais(String fullPathToFile,FraisXML newFrais)
    {
        Integer newID = 0;
        Boolean mustUpDate = false;
        ArrayList<FraisXML> lesFrais = this.parseFrais(fullPathToFile);

        if(newFrais.IdOperation != null && newFrais.IdOperation != "")
        {
            mustUpDate = true;
        }

        for(FraisXML fr : lesFrais)
        {
            if(mustUpDate)
            {
                if(fr.IdOperation.equals(newFrais.IdOperation))
                {
                    fr.PeriodeLocation = newFrais.PeriodeLocation;
                    fr.Devise = newFrais.Devise;
                    fr.PrixPeriode = newFrais.PrixPeriode;
                    fr.TypeCoffre = newFrais.TypeCoffre;
                }
            }else
            {
                if(newID < Integer.parseInt(fr.IdOperation))
                {
                    newID = Integer.parseInt(fr.IdOperation);
                }
            }
        }

        if(!mustUpDate)
        {
            newID += 1;

            newFrais.IdOperation = newID.toString();

            lesFrais.add(newFrais);
        }

        try {
            FraisXMLs operas = new FraisXMLs();
            JAXBContext jc2 = JAXBContext.newInstance(FraisXMLs.class);
            Marshaller marshaller = jc2.createMarshaller();

            operas.operations = lesFrais;
            marshaller.marshal(operas, new File(fullPathToFile));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return this.parseFrais(fullPathToFile);

    }

    public ArrayList<FraisXML> parseFrais(String fullPathToFile)
    {

        File file = new File(fullPathToFile);

        ArrayList<FraisXML> lesOperations = new ArrayList<>();

        try
        {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(file);
            NodeList nodes = doc.getElementsByTagName("FraisXML");

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

    public Frais fraisById(String fullPathToFile, String id)
    {
        File file = new File(fullPathToFile);
        FraisXML fraisToReturn = new FraisXML();

        try
        {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(file);
            NodeList nodes = doc.getElementsByTagName("FraisXML");

            JAXBContext jc = JAXBContext.newInstance(FraisXML.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();

            for(int i = 0; i < nodes.getLength(); i++)
            {
                JAXBElement<FraisXML> je = unmarshaller.unmarshal(nodes.item(i), FraisXML.class);
                FraisXML op = je.getValue();
                if(op.IdOperation.equals(id))
                {
                    fraisToReturn = op;
                }
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

        return new Frais(fraisToReturn);
    }

    public Coffre CoffreById(String fullPathToFile, String id)
    {
        File file = new File(fullPathToFile);
        Coffre coffre = new Coffre();

        try
        {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(file);
            NodeList nodes = doc.getElementsByTagName("CoffreXML");

            JAXBContext jc = JAXBContext.newInstance(CoffreXML.class);

            Unmarshaller unmarshaller = jc.createUnmarshaller();

            for(int i = 0; i < nodes.getLength(); i++)
            {
                JAXBElement<CoffreXML> je = unmarshaller.unmarshal(nodes.item(i), CoffreXML.class);
                CoffreXML co = je.getValue();
                if(co.idCoffre.equals(id))
                {
                    coffre.setIdCoffre(Integer.parseInt(co.idCoffre));
                    coffre.setPiece(co.piece);
                    coffre.setTypeCoffre(co.typeCoffre);
                    coffre.setContenu(co.contenu);
                    coffre.setDateOuverture(co.dateOuverture);
                    coffre.setDateFermeture(co.dateFermeture);
                }
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

        return coffre;
    }

    public void deleteCoffre(String fullPathToFile, String id)
    {
        File file = new File(fullPathToFile);

        ArrayList<AgenceXML> lesAgences = new ArrayList<>();
        //ArrayList<Agence> agences = new ArrayList<Agence>();

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
                if(agenceXML.listeClient != null){
                    for(ClientBanqueXML clientXML : agenceXML.listeClient)
                    {
                        if(clientXML.Coffres != null)
                        {
                            for (Iterator<CoffreXML> iter = clientXML.Coffres.listIterator(); iter.hasNext(); ) {
                                CoffreXML a = iter.next();
                                if (a.idCoffre.equals(id)) {
                                    iter.remove();
                                }
                            }
                        }
                    }
                }
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

        try {
            AgencesXML agences = new AgencesXML();
            JAXBContext jc2 = JAXBContext.newInstance(AgencesXML.class);
            Marshaller marshaller = jc2.createMarshaller();

            agences.agences = lesAgences;
            marshaller.marshal(agences, new File(fullPathToFile));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
