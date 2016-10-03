package javacesi;

import java.util.List;

import static java.lang.System.in;

/**
 * Created by Emna, Julien & Paul on 14/09/2016.
 **/

public class ClientBanque implements ICrud, extends Individu
{

	private List<Coffre> coffres;
	
	// Constructeurs
	public ClientBanque(int id, String nm, String pn, Agence agr) {
		super(id,nm,pn,agr);
	}
	
	public ClientBanque() {
        super();
		
	}

    public Coffre getCoffreParDefaut()
    {
        Coffre coffreToReturn = new Coffre();
        for(Coffre c : this.coffres)
        {
            if(c.isCoffreParDefault())
            {
                coffreToReturn = c;
            }
        }

        return coffreToReturn;
    }

    public void addCoffre(Coffre c)
    {
        this.coffres.add(c);
    }

    public List<Coffre> getCoffres()
    {
        return this.coffres;
    }

    // Méthode de renvoi du client sous sa forme usuelle : PRENOM - NOM
    public String toString() 
    {
		return this.getPrenom() + " " + this.getNom();
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
