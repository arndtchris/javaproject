package javacesi;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 06/10/2016.
 */
@XmlRootElement(name = "AgenceXML")
@XmlType(propOrder = {"Adresse","listeClient","Nom", "idAgence"})
public class AgenceXML {
    @XmlElement(name = "Adresse")
    public String Adresse;
    @XmlElement(name = "Nom")
    public String Nom;
    @XmlElement(name = "idAgence")
    public int idAgence;
    @XmlElementWrapper(name = "listeClient")
    @XmlElement(name = "ClientBanqueXML")
    public List<ClientBanqueXML> listeClient;
}
