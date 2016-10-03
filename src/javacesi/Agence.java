package javacesi;

import java.util.ArrayList;

public class Agence extends Etablissement implements ICrud
{

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
        super();
        listeCoffre = new ArrayList<Coffre>();
        listeClient = new ArrayList<ClientBanque>();
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
