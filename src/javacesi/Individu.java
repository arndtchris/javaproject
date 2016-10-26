package javacesi;

/**
 * Created by chris on 03/10/2016.
 */
public class Individu{

    private String nom;
    private String prenom;
    private String adresse;
    private Agence agenceRattachement;

    public Individu()
    {

    }

    public Individu(String nm, String pn, Agence agr)
    {
        this.nom = nm;
        this.prenom = pn;
        this.agenceRattachement = agr;
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

    public String getAdresse()
    {
        return this.adresse;
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

    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }
}
