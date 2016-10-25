package javacesi;

import java.util.ArrayList;

public class Agence extends Etablissement
{

    private ArrayList<Coffre> listeCoffre;


    /**
     * Constructeur vide de la classe Agence. Instancie les listes ListeCoffre et ListeClient.
     */
    public Agence()
    {
        super();
        listeCoffre = new ArrayList<Coffre>();
        this.setNomEtab("");
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
}
