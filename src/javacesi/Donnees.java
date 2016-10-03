package javacesi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Donnees {

	// Jeux de données
		// Jeux de données

		// Création d'une liste d'agences
	private Agence a1 = new Agence();
	private Agence a2 = new Agence();
	private Agence a3 = new Agence();
	private Agence a4 = new Agence();
	private Agence a5 = new Agence();
	private Agence a6 = new Agence();
	private Agence a7 = new Agence();
	private Agence a8 = new Agence();

		// Création de plusieurs ArrayList(s) d'agences
	public ArrayList<Agence> listeAgence1 = new ArrayList<Agence>();
	public ArrayList<Agence> listeAgence2 = new ArrayList<Agence>();
	public ArrayList<Agence> listeAgence3 = new ArrayList<Agence>();

	//Liste de banques
	public ArrayList<Banque> listeDeBanque = new ArrayList<Banque>();

	// Création & association de la liste de banque au groupement de banque
	public GroupementBanque groupementDeBanque = new GroupementBanque();

	//CRéation d'une liste de coffre
	public ArrayList<Coffre> tousLesCoffres = new ArrayList<Coffre>();

	//Création d'une liste de client
	public ArrayList<ClientBanque> lesCients = new ArrayList<ClientBanque>();


	// Création d'une liste de secteurs
	private Secteur s1 = new Secteur("Nancy",54000,"France");
	private Secteur s2 = new Secteur("Paris",75000,"France");
	private Secteur s3 = new Secteur("Lyon",69001,"France");

	// Création d'une liste de banques
	private Banque b1 = new Banque("BANQUE POPULAIRE");
	private Banque b2 = new Banque("BANQUE LCL");
	private Banque b3 = new Banque("BANQUE BNP PARIBAS");

	// Création d'une liste de coffres
	private Coffre cf1 = new Coffre(1,"1er Etage","Armoire forte","Acier 50L",null,500000,new ArrayList<Operation>());
	private Coffre cf2 = new Coffre(2,"2eme Etage","Armoire forte","Acier 50L",null,25000,new ArrayList<Operation>());
	private Coffre cf3 = new Coffre(3,"2eme Etage","Armoire forte","Acier 50L",null,0,new ArrayList<Operation>());
	private Coffre cf4 = new Coffre(4,"2eme Etage","Armoire forte","Acier 50L",null,20,new ArrayList<Operation>());
	private Coffre cf5 = new Coffre(5,"3eme Etage","Armoire forte","Acier 50L",null,0.99,new ArrayList<Operation>());

	// Création d'une liste de clients
	private ClientBanque cl1 = new ClientBanque(1,"Schmit","Aurélien",a1,cf1);
	private ClientBanque cl2 = new ClientBanque(2,"Castro","Fidel",a2,cf2);
	private ClientBanque cl3 = new ClientBanque(3,"Trump","Donald",a5,cf4);


	// Création de dates
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private String d1 = "01/01/2015";
	private String d2 = "12/05/2012";
	private String d3 = "25/08/2014";

	private Date d1e = new Date();
	private Date d2e = new Date();
	private Date d3e = new Date();

	// Création des frais
	private Frais fra1;
	private Frais fra2;
	private Frais fra3;

	// Création des opérations
	private Operation op1 = new Operation();

	private Operation op2 = new Operation();

	private Operation op3 = new Operation();

	public Donnees()
	{

		//Génération des listes d'agence
		listeAgence1.add(a1);
		listeAgence1.add(a2);
		listeAgence1.add(a3);

		listeAgence2.add(a4);
		listeAgence2.add(a5);

		listeAgence3.add(a6);
		listeAgence3.add(a7);
		listeAgence3.add(a8);

		// Création d'une liste de secteurs

		s1.AddAgence(a1);
		s1.AddAgence(a2);
		s1.AddAgence(a3);

		s1.AddAgence(a4);
		s1.AddAgence(a5);

		s1.AddAgence(a6);
		s1.AddAgence(a7);
		s1.AddAgence(a8);

		//Génération des banques
		b1.AddSecteur(s1);
		b1.AddSecteur(s2);
		b1.AddSecteur(s3);

		// Création & association de la liste de banque au groupement de banque
		groupementDeBanque.AddBanque(b1);
		groupementDeBanque.AddBanque(b2);
		groupementDeBanque.AddBanque(b3);

		// Création d'une liste de frais
		Frais fr1 = new Frais();
		Frais fr2 = new Frais();
		Frais fr3 = new Frais();
		
		// Création d'une liste de coffres
		// Création d'une liste de clients
		ClientBanque cl1 = new ClientBanque(1,"Schmit","Aurélien",a1,cf1);
		ClientBanque cl2 = new ClientBanque(2,"Castro","Fidel",a2,cf2);
		ClientBanque cl3 = new ClientBanque(3,"Trump","Donald",a5,cf4);
		
		// Création de dates
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String d1 = "01/01/2015";
		String d2 = "12/05/2012";
		String d3 = "25/08/2014";
		
		Date d1e = new Date();
		op1.setDebut(d1e);
		op1.setTypeOp("Retrait");
		op1.setFin(d1e);
		op1.setClt(cl1);
		try {
			d1e = formatter.parse(d1);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date d2e = new Date();
		op2.setTypeOp("Dépôt");
		op2.setDebut(d2e);
		op2.setFin(d2e);
		op2.setClt(cl2);
		try {
			d2e = formatter.parse(d2);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Date d3e = new Date();
		op3.setTypeOp("Retrait");
		op3.setDebut(d3e);
		op3.setFin(d3e);
		op3.setClt(cl3);
		try {
			d3e = formatter.parse(d3);
		} catch (ParseException e) {

			e.printStackTrace();
		}

		// Création des frais
		Frais fra1 = new Frais(1,d1e,(float) 200.0,"Contr�le des huissiers");
		Frais fra2 = new Frais(2,d2e,(float) 100.0,"Taxe");
		Frais fra3 = new Frais(3,d3e,(float) 50.0,"Contr�le de routine");
		
		// Création des opérations
		op1.setFrs(fra1);
		op2.setFrs(fra2);
		op3.setFrs(fra3);
		
		// Création d'une liste de banque
		listeDeBanque.add(b1);
		listeDeBanque.add(b2);
		listeDeBanque.add(b3);

		cf1.setClient(cl1);
		cf1.setOperation(op1);
		cf2.setClient(cl1);
		cf2.setOperation(op2);
		cf3.setClient(cl2);
		cf3.setOperation(op3);
		cf4.setClient(cl3);

		//Liste des coffres
		tousLesCoffres.add(cf1);
		tousLesCoffres.add(cf2);
		tousLesCoffres.add(cf3);
		tousLesCoffres.add(cf4);
		tousLesCoffres.add(cf5);

		//Liste des clients
		lesCients.add(cl1);
		lesCients.add(cl2);
		lesCients.add(cl3);
	}

}
