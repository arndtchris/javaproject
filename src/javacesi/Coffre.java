package javacesi;

import java.util.ArrayList;
import java.util.List;

public class Coffre implements ICrud
{
    private int idCoffre;
    private String typeCoffre;
    private ClientBanque client;

    private String dateOuverture;
    private String dateFermeture;
    private String piece;
    private String contenu;


    //constructeurs

    public Coffre(int id, String typec, ClientBanque cl)
    {
        this.idCoffre = id;
        this.typeCoffre = typec;
        this.client = cl;
    }

    public Coffre(String id,String dateOuverture, String dateFermeture, String contenu )
    {
        this.idCoffre = Integer.parseInt(id);
        this.dateOuverture = dateOuverture;
        this.dateFermeture = dateFermeture;
        this.contenu = contenu;
    }

    public Coffre(CoffreXML c)
    {
        idCoffre = Integer.parseInt(c.idCoffre);
        typeCoffre = c.typeCoffre;
        dateFermeture = c.dateFermeture;
        dateOuverture = c.dateOuverture;
        contenu = c.contenu;
    }

    public Coffre()
    {

    }

    //getter
    public int getIdCoffre()
    {
        return this.idCoffre;
    }

    public String getTypeCoffre()
    {
        return this.typeCoffre;
    }

    public ClientBanque getClient()
    {
        return this.client;
    }


    //setter

    public void setIdCoffre(int identifiant)
    {
        this.idCoffre = identifiant;
    }

    public void setTypeCoffre(String tCoffre)
    {
        this.typeCoffre = tCoffre;
    }

    public void setClient(ClientBanque iClient)
    {
        this.client = iClient;
    }


    //Methodes


    public void afficheCoffre()
    {
        System.out.println("Coffre n°"+this.idCoffre);
        System.out.println("Type : "+this.typeCoffre);
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

    public String getDateOuverture() {
        return dateOuverture;
    }

    public void setDateOuverture(String dateOuverture) {
        this.dateOuverture = dateOuverture;
    }

    public String getDateFermeture() {
        return dateFermeture;
    }

    public void setDateFermeture(String dateFermeture) {
        this.dateFermeture = dateFermeture;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}