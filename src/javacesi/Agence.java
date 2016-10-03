package javacesi;

import java.util.ArrayList;

public class Agence
{
    /**
     * Nom de l'agence
     */
    private String nom;

    /**
     * Adresse de l'agence
     * exemple: 3, rue charles
     */
    private String adresse;

    /**
     * Liste des coffres de l'agence
     */
    private ArrayList<Coffre> listeCoffre;

    /**
     * Liste des clients de l'agence
     */
    private ArrayList<ClientBanque> listeClient;


    /**
     * Constructeur vide de la classe Agence. Instancie les listes ListeCoffre et ListeClient.
     */
    public Agence()
    {
        listeCoffre = new ArrayList<Coffre>();
        listeClient = new ArrayList<ClientBanque>();
    }

    /**
     * Constructeur de la classe Agence.
     * @param nom : nom de l'agence
     * @param adresse : adresse de l'agence
     */
    public Agence(String nom, String adresse)
    {
        listeCoffre = new ArrayList<Coffre>();
        listeClient = new ArrayList<ClientBanque>();
        this.nom = nom;
        this.adresse = adresse;
    }

    /**
     * Méthode SetNom permettant de modifier le nom de l'agence
     * @param nom
     */
    public void SetNom(String nom)
    {
        this.nom = nom;
    }

    /**
     * Méthode GetNom permettant de récupérer le nom de l'agence.
     * @return nom
     */
    public String GetNom()
    {
        return nom;
    }

    /**
     * Méthode GetAdresse permettant de récupérer l'adresse de l'agence.
     * @return adresse
     */
    public String GetAdresse()
    {
        return adresse;
    }

    /**
     * Méthode SetAdresse permettant de modifier l'adresse de l'agence.
     * @param adresse
     */
    public void SetAdresse(String adresse)
    {
        this.adresse = adresse;
    }

    /**
     * Méthode AddCoffre permettant d'ajouter un coffre à la liste de coffres de l'agence.
     * @param coffre
     */
    public void AddCoffre(Coffre coffre)
    {
        listeCoffre.add(coffre);
    }

    /**
     * Méthode GetListeCoffre permettant de récupérer la liste de coffres de l'agence.
     * @return listeCoffre
     */
    public ArrayList<Coffre> GetListeCoffre()
    {
        return listeCoffre;
    }

    /**
     * Méthode
     * @return
     */
    public ArrayList<ClientBanque> GetListeClient()
    {
        return listeClient;
    }

    public void AddClient(ClientBanque c)
    {
        listeClient.add(c);
    }

}
