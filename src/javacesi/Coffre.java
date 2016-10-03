package javacesi;

import java.util.ArrayList;
import java.util.List;

public class Coffre implements ICrud
{
    private int id;
    private String localisation;
    private String typeCoffre;
    private String typeSecurite;
    private ClientBanque client;
    private double montant;
    private List<Operation> operations = new ArrayList<Operation>();


    //constructeurs

    public Coffre(int id, String loc, String typec, String types, ClientBanque cl, double montant, List<Operation> lesOperations)
    {
        this.id = id;
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
    public int getId()
    {
        return this.id;
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

    //setter

    public void setId(int identifiant)
    {
        this.id = identifiant;
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

    //Methodes

    public void afficheOperations()
    {
        System.out.println("Liste des opérations du coffre n°" + this.id);
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
        System.out.println("Coffre n°"+this.id);
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
    public void Create(int id) {

    }

    @Override
    public <T> void Read(T object) {

    }

    @Override
    public <T> void Update(T object) {

    }

    @Override
    public void Delete(int id) {

    }
}