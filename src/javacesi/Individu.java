package javacesi;

/**
 * Created by chris on 03/10/2016.
 */
public class Individu {

    private int id;
    private String nom;
    private String prenom;
    private Agence agenceRattachement;

    public Individu()
    {

    }

    public Individu(int id, String nm, String pn, Agence agr)
    {
        this.id = id;
        this.nom = nm;
        this.prenom = pn;
        this.agenceRattachement = agr;
    }

    public int getId()
    {
        return this.id;
    }

    public String getNom()
    {
        return this.nom;
    }

    public String getPrenom()
    {
        return this.prenom;
    }

    public Agence getAgenceRattachement()
    {
        return this.agenceRattachement;
    }


    public void setId(int id)
    {
        this.id = id;
    }

    public void setNom(String nm)
    {
        this.nom = nm;
    }

    public void setPrenom(String pn)
    {
        this.prenom = pn;
    }

    public void setAgenceRattachement(Agence agr)
    {
        this.agenceRattachement = agr;
    }
}
