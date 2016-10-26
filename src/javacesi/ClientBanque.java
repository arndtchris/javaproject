package javacesi;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;

/**
 * Created by Emna, Julien & Paul on 14/09/2016.
 **/

public class ClientBanque extends Individu
{

	private ArrayList<Coffre> coffres;
    private int idClient;
	
	// Constructeurs
	public ClientBanque(String nm, String pn, Agence agr) {
		super(nm,pn,agr);
	}

    public ClientBanque(int id, String nm, String pn, Agence agr, Coffre cfr) {
        coffres = new ArrayList<Coffre>();
        this.setIdClient(id);
        this.setNom(nm);
        this.setPrenom(pn);
        this.setAgenceRattachement(agr);
        this.coffres.add(cfr);
    }
	
	public ClientBanque() {
        super();
        this.coffres = new ArrayList<Coffre>();
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

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}
