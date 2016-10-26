package javacesi;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chris on 26/10/2016.
 */
@XmlRootElement(name = "AgencesXML")
public class AgencesXML {
    @XmlElement(name = "AgenceXML")
    public List<AgenceXML> agences;
}