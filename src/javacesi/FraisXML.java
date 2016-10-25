package javacesi;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * Created by chris on 25/10/2016.
 */
@XmlRootElement(name = "CoffreXML")
@XmlType(propOrder = {"TypeCoffre","PeriodeLocation","PrixPeriode","Devise"})
public class FraisXML {

    @XmlElement(name = "TypeCoffre")
    public String TypeCoffre;
    @XmlElement(name = "PeriodeLocation")
    public String PeriodeLocation;
    @XmlElement(name = "PrixPeriode")
    public String PrixPeriode;
    @XmlElement(name = "Devise")
    public String Devise;
}
