package javacesi;

import java.util.ArrayList;
import java.util.List;

public class Coffre implements ICrud
{
    private int idCoffre;
    private String localisation;
    private String typeCoffre;
    private String typeSecurite;
    private ClientBanque client;
    private double montant;
    private List<Operation> operations = new ArrayList<Operation>();
    private boolean coffreParDefault;
    protected Double decouvert;
    protected Double plafond;
    protected Double interet;
    protected Double maxRetrait;
    protected Double maxDepot;
    protected boolean peutFaireVirement;
    protected String objets;


    //constructeurs

    public Coffre(int id, String loc, String typec, String types, ClientBanque cl, double montant, List<Operation> lesOperations)
    {
        this.idCoffre = id;
        this.localisation = loc;
        this.typeCoffre = typec;
        this.typeSecurite = types;
        this.client = cl;
        this.montant = montant;
        this.operations = lesOperations;
    }

    public Coffre()
    {

    }

    //getter
    public int getIdCoffre()
    {
        return this.idCoffre;
    }

    public String getLocalisation()
    {
        return this.localisation;
    }

    public String getTypeCoffre()
    {
        return this.typeCoffre;
    }

    public String getTypeSecurite()
    {
        return this.typeSecurite;
    }

    public ClientBanque getClient()
    {
        return this.client;
    }

    public double getMontant()
    {
        return this.montant;
    }

    public List<Operation> getOperations()
    {
        return this.operations;
    }

    public boolean isCoffreParDefault()
    {
        return  this.coffreParDefault;
    }

    public boolean peutFaireVirement()
    {
        return this.peutFaireVirement;
    }

    public double decouvertAutorise()
    {
        return this.decouvert;
    }

    public double getPlafond()
    {
        return this.plafond;
    }

    public double getInteret()
    {
        return this.interet;
    }

    public double getMaxRetrait()
    {
        return this.maxRetrait;
    }

    public double getMaxDepot()
    {
        return this.maxDepot;
    }

    public String getObjets()
    {
        return this.objets;
    }

    //setter

    public void setIdCoffre(int identifiant)
    {
        this.idCoffre = identifiant;
    }

    public void setLocalisation(String loc)
    {
        this.localisation = loc;
    }

    public void setTypeCoffre(String tCoffre)
    {
        this.typeCoffre = tCoffre;
    }

    public void setTypeSecurite(String tSecurite)
    {
        this.typeSecurite = tSecurite;
    }

    public void setClient(ClientBanque iClient)
    {
        this.client = iClient;
    }

    public void setMontant(double montant)
    {
        this.montant = montant;
    }

    public void setOperation(Operation ope)
    {
        this.operations.add(ope);
    }

    public void setCoffreParDefaut()
    {
        this.coffreParDefault = true;
    }

    public void setObjets(String objets)
    {
        this.objets = objets;
    }

    //Methodes

    public void afficheOperations()
    {
        System.out.println("Liste des opérations du coffre n°" + this.idCoffre);
        if(this.getOperations() != null && this.getOperations().size() > 0)
        {
            for(Operation operation : this.getOperations())
            {
                System.out.println("    "+operation.getTypeOp()
                        +" effectué par "+ operation.getClt().getPrenom()+" "+operation.getClt().getNom()
                        +", début : " + operation.getDebut()
                        + ", fin " + operation.getFin());
            }
        }else
        {
            System.out.println("Aucune opération");
        }

    }

    public void afficheCoffre()
    {
        System.out.println("Coffre n°"+this.idCoffre);
        System.out.println("Type : "+this.typeCoffre);
        System.out.println("Sécurité : "+this.typeSecurite);
        System.out.println("Montant : "+this.montant+ "€");
        if(this.client == null){
            System.out.println("N'appartient à personne");
        }else
        {
            System.out.println("Appartient à "+ this.client.getPrenom() + " " + this.client.getNom());
        }
    }

    @Override
    public void Create() {

    }

    @Override
    public void Read() throws AlsCustomException {
        if (this.idCoffre == 0)
        {
            // throw our custom exception
            throw new AlsCustomException("Le coffre n'existe pas");
        }
        else
        {
            this.afficheCoffre();
        }
    }

    @Override
    public void Update() throws AlsCustomException {
        if (this.idCoffre == 0)
        {
            // throw our custom exception
            throw new AlsCustomException("Le coffre n'existe pas");
        }
        else
        {
            System.out.println("Le coffre a été modifié");
        }
    }

    @Override
    public void Delete() throws AlsCustomException {
        if (this.idCoffre == 0)
        {
            // throw our custom exception
            throw new AlsCustomException("Le coffre n'existe pas");
        }
        else
        {
            System.out.println("le coffre a été supprimé");
        }
    }

}