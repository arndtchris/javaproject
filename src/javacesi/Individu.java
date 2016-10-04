package javacesi;

/**
 * Created by chris on 03/10/2016.
 */
public class Individu implements ICrud {

    private int id;
    private String nom;
    private String prenom;
    private String adresse;
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

    public String getAdresse()
    {
        return this.adresse;
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

    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }


    @Override
    public void Create() {

    }

    @Override
    public void Read() throws AlsCustomException {
        if (this.id == 0)
        {
            // throw our custom exception
            throw new AlsCustomException("Cette personne n'est pas enregistrée");
        }
        else
        {
            System.out.println("Je décris la personne");
        }
    }

    @Override
    public void Update() throws AlsCustomException {
        if (this.id == 0)
        {
            // throw our custom exception
            throw new AlsCustomException("Cette personne n'est pas enregistrée");
        }
        else
        {
            System.out.println("Le profil a été modifié");
        }
    }

    @Override
    public void Delete() throws AlsCustomException {
        if (this.id == 0)
        {
            // throw our custom exception
            throw new AlsCustomException("Cette personne n'est pas enregistrée");
        }
        else
        {
            System.out.println("Le profil a été supprimé");
        }
    }
}
