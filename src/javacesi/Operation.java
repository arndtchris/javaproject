package javacesi;
import java.util.Date;


public class Operation {

    // Variables //
    private Date debut;
    private Date fin;
    private String typeOp;

    private ClientBanque clt;
    private Coffre cfre;
    private Frais frs;

    // Constructors //

    public Operation(){}
    public Operation(Date d, Date f, String t){
        this.debut = d;
        this.fin = f;
        this.typeOp = t;
    }

    // Getter / Setter //

    public Date getDebut() {
        return debut;
    }
    public void setDebut(Date debut) {
        this.debut = debut;
    }
    public Date getFin() {
        return fin;
    }
    public void setFin(Date fin) {
        this.fin = fin;
    }
    public String getTypeOp() {
        return typeOp;
    }
    public void setTypeOp(String typeOp) {
        this.typeOp = typeOp;
    }
    public Coffre getCfre() {
        return cfre;
    }
    public void setCfre(Coffre cfre) {
        this.cfre = cfre;
    }
    public ClientBanque getClt() {
        return clt;
    }
    public void setClt(ClientBanque clt) {
        this.clt = clt;
    }
    public Frais getFrs() {
        return frs;
    }
    public void setFrs(Frais frs) {
        this.frs = frs;
    }

}
