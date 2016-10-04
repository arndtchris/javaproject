package javacesi;

import java.util.ArrayList;

public class Secteur implements ICrud
{
    private String ville;
    private int codePostal;
    private String pays;
    private ArrayList<Agence> listeAgence;

    public Secteur()
    {
        listeAgence = new ArrayList<Agence>();
    }

    public Secteur(String ville, int codePostal, String pays)
    {
        this.ville = ville;
        this.codePostal = codePostal;
        this.pays = pays;
        listeAgence = new ArrayList<Agence>();
    }

    public void SetVille(String ville)
    {
        this.ville = ville;
    }

    public String GetVille()
    {
        return ville;
    }

    public int GetCodePostal()
    {
        return codePostal;
    }

    public void SetCodePostale(int code)
    {
        codePostal = code;
    }

    public void SetPays(String pays)
    {
        this.pays = pays;
    }

    public String GetPays()
    {
        return pays;
    }

    public ArrayList<Agence> GetListeAgence()
    {
        return listeAgence;
    }

    public void AddAgence(Agence agence)
    {
        listeAgence.add(agence);
    }

    public Agence GetAgence(int i)
    {
        if(i >= listeAgence.size() || i < 0)
            return null;
        else
            return listeAgence.get(i);
    }

    @Override
    public void Create() {

    }

    @Override
    public void Read() {

    }

    @Override
    public void Update() {

    }

    @Override
    public void Delete() {

    }
}
