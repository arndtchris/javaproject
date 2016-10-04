package javacesi;

import java.util.ArrayList;

public class Banque extends Etablissement implements ICrud
{
    private String designation;
    private ArrayList<Secteur> listeSecteur;

    public Banque()
    {
        super();
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
