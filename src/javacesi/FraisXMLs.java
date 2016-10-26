package javacesi;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chris on 04/10/2016.
 */
@XmlRootElement(name = "FraisXMLs")
public class FraisXMLs {
    @XmlElement(name = "FraisXML")
    public List<FraisXML> operations;
}
