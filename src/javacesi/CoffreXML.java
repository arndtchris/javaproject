package javacesi;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by chris on 06/10/2016.
 */
@XmlRootElement(name = "CoffreXML")
@XmlType(propOrder = {"typeCoffre","dateOUverture","dateFermeture","contenu","piece"})
public class CoffreXML {

    @XmlElement(name = "typeCoffre")
    public String typeCoffre;
    @XmlElement(name = "dateOUverture")
    public String dateOUverture;
    @XmlElement(name = "dateFermeture")
    public String dateFermeture;
    @XmlElement(name = "contenu")
    public String contenu;
    @XmlElement(name = "piece")
    public String piece;

}
