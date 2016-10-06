package javacesi;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by chris on 06/10/2016.
 */

@XmlRootElement(name = "TraceXML")
@XmlType(propOrder = {"TypeCoffre", "PeriodeLocation", "PrixPeriode", "Devise"})
public class TraceXML {
}
