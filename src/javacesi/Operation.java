package javacesi;
import java.util.Date;


public class Operation implements ICrud
{

    // Variables //
    private int id;
    private Date debut;
    private Date fin;
    private String typeOp;

    private ClientBanque clt;
    private Coffre cfre;
    private Frais frs;

    // Constructors //

    public Operation(){}
    public Operation(int id, Date d, Date f, String t){
        this.id = id;
        this.debut = d;
        this.fin = f;
        this.typeOp = t;
    }

    // Getter / Setter //

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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

    @Override
    public void Create() {

    }

    @Override
    public void Read() throws AlsCustomException {
        if (this.id == 0)
        {
            // throw our custom exception
            throw new AlsCustomException("L'opération n'existe pas");
        }
        else
        {
            System.out.println("Je décris l'opération");
        }
    }

    @Override
    public void Update() throws AlsCustomException {
        if (this.id == 0)
        {
            // throw our custom exception
            throw new AlsCustomException("L'opération n'existe pas");
        }
        else
        {
            System.out.println("Opération modifiée");
        }
    }

    @Override
    public void Delete() throws AlsCustomException {
        if (this.id == 0)
        {
            // throw our custom exception
            throw new AlsCustomException("L'opération n'existe pas");
        }
        else
        {
            System.out.println("Opération supprimée");
        }
    }
}
