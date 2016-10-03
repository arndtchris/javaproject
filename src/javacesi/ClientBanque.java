package javacesi;

/**
 * Created by Emna, Julien & Paul on 14/09/2016.
 **/

public class ClientBanque {
	
	private int id;
	private String nom;
	private String prenom;
	private Agence agenceRattachement;
	
	private Coffre coffre;
	
	// Constructeurs
	public ClientBanque(int id, String nm, String pn, Agence agr, Coffre cfr) {
		this.id = id;
		this.nom = nm;
		this.prenom = pn;
		this.agenceRattachement = agr;
		this.coffre = cfr;
	}
	
	public ClientBanque() {
		
	}
	
	// Getter
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
    
	// Setter
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
    
    // Méthode de renvoi du client sous sa forme usuelle : PRENOM - NOM
    public String toString() 
    {
		return this.prenom + " " + this.nom;
    }
    
}
