package javacesi;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chris on 04/10/2016.
 */
@XmlRootElement(name = "OperationXMLs")
public class OperationXMLs {
    @XmlElement(name = "OperationXML")
    public List<OperationXML> operations;
}
