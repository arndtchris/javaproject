package javacesi;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chris on 06/10/2016.
 */
@XmlRootElement(name = "AgenceXML")
@XmlType(propOrder = {"Adresse","listeClient"})
public class AgenceXML {
    @XmlElement(name = "Adresse")
    public String Adresse;
    @XmlElement(name = "listeClient")
    List<ClientBanqueXML> listeClient;
}
