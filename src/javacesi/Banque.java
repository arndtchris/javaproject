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
    public void Create(int id) {

    }

    @Override
    public <T> void Read(T object) {

    }

    @Override
    public <T> void Update(T object) {

    }

    @Override
    public void Delete() {

    }
}
