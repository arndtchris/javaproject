package javacesi;

import java.util.ArrayList;

public class Banque
{
    private String designation;
    private ArrayList<Secteur> listeSecteur;

    public Banque()
    {
        listeSecteur = new ArrayList<Secteur>();
    }

    public Banque(String designation)
    {
        this.designation = designation;
        listeSecteur = new ArrayList<Secteur>();
    }

    public void SetDesignation(String designation)
    {
        this.designation = designation;
    }

    public String GetDesignation()
    {
        return designation;
    }

    public void AddSecteur(Secteur secteur)
    {
        listeSecteur.add(secteur);
    }

    public ArrayList<Secteur> GetListeSecteur()
    {
        return listeSecteur;
    }

}
