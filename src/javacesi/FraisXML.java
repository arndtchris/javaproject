package javacesi;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;

/**
 * Created by chris on 25/10/2016.
 */
@XmlRootElement(name = "OperationXML")
@XmlType(propOrder = {"IdOperation","TypeCoffre","PeriodeLocation","PrixPeriode","Devise"})
public class FraisXML {

    @XmlElement(name = "IdOperation")
    public String IdOperation;
    @XmlElement(name = "TypeCoffre")
    public String TypeCoffre;
    @XmlElement(name = "PeriodeLocation")
    public String PeriodeLocation;
    @XmlElement(name = "PrixPeriode")
    public String PrixPeriode;
    @XmlElement(name = "Devise")
    public String Devise;

    public FraisXML()
    {

    }

    public FraisXML(String typeCoffre, String periodeLocation, String prixPeriode,String devise) {
        this.TypeCoffre = typeCoffre;
        this.PeriodeLocation = periodeLocation;
        this.PrixPeriode = prixPeriode;
        this.Devise = devise;
    }
}
