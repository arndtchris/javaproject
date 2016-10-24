package javacesi;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by chris on 06/10/2016.
 */
@XmlRootElement(name = "ClientBanqueXML")
@XmlType(propOrder = {"prenom","nom","adresse","Coffres"})
public class ClientBanqueXML {

    @XmlElement(name = "prenom")
    public String prenom;
    @XmlElement(name = "nom")
    public String nom;
    @XmlElement(name = "adresse")
    public String adresse;
    @XmlElementWrapper(name = "Coffres")
    @XmlElement(name = "CoffreXML")
    public List<CoffreXML> Coffres;

}
