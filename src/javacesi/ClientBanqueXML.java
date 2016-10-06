package javacesi;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * Created by chris on 06/10/2016.
 */
@XmlRootElement(name = "ClientBanqueXML")
@XmlType(propOrder = {"prenom","nom","adresse","coffres"})
public class ClientBanqueXML {

    @XmlElement(name = "prenom")
    public String prenom;
    @XmlElement(name = "nom")
    public String nom;
    @XmlElement(name = "adresse")
    public String adresse;
    @XmlElement(name = "coffres")
    public List<CoffreXML> coffres;

}
