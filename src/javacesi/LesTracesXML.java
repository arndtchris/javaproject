package javacesi;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by chris on 06/10/2016.
 */
@XmlRootElement(name = "LesTracesXML")
public class LesTracesXML {
    @XmlElement(name = "TraceXML")
    public List<TraceXML> lesTraces;
}
