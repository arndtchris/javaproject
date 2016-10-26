package javacesi;

import java.util.Date;

/**
 * Classe Frais
 * 
 * @author etienne
 *
 */
public class Frais implements ICrud
{
	private Integer idFrais;
	private String typecoffre;
	private String periodeLocation;
	private String prixPeriode;
	private String devise;

	public Frais() {
	}

	public Frais(FraisXML f)
	{
		this.typecoffre = f.TypeCoffre;
		this.devise = f.Devise;
		this.periodeLocation = f.PeriodeLocation;
		this.prixPeriode = f.PrixPeriode;
		this.idFrais = Integer.parseInt(f.IdOperation);
	}

	public Frais(Integer aIdFrais, String typeCoffre, String periodeLocation, String prixPeriode,String devise) {
		this.idFrais = aIdFrais;
		this.typecoffre = typeCoffre;
		this.periodeLocation = periodeLocation;
		this.prixPeriode = prixPeriode;
		this.devise = devise;
	}

	public Frais(String typeCoffre, String periodeLocation, String prixPeriode,String devise) {
		this.typecoffre = typeCoffre;
		this.periodeLocation = periodeLocation;
		this.prixPeriode = prixPeriode;
		this.devise = devise;
	}



	@Override
	public void Create() {

	}

	@Override
	public void Read() throws AlsCustomException {
		if (this.idFrais == 0)
		{
			// throw our custom exception
			throw new AlsCustomException("Ce frais n'existe pas");
		}
		else
		{
			System.out.println("Je décris le frais");
		}
	}

	@Override
	public void Update() throws AlsCustomException {
		if (this.idFrais == 0)
		{
			// throw our custom exception
			throw new AlsCustomException("Ce frais n'existe pas");
		}
		else
		{
			System.out.println("Frais modifié");
		}
	}

	@Override
	public void Delete() throws AlsCustomException {
		if (this.idFrais == 0)
		{
			// throw our custom exception
			throw new AlsCustomException("Ce frais n'existe pas");
		}
		else
		{
			System.out.println("Frais supprimé");
		}
	}

	public String getTypecoffre() {
		return typecoffre;
	}

	public void setTypecoffre(String typecoffre) {
		this.typecoffre = typecoffre;
	}

	public String getPeriodeLocation() {
		return periodeLocation;
	}

	public void setPeriodeLocation(String periodeLocation) {
		periodeLocation = periodeLocation;
	}

	public String getPrixPeriode() {
		return prixPeriode;
	}

	public void setPrixPeriode(String prixPeriode) {
		prixPeriode = prixPeriode;
	}

	public String getDevise() {
		return devise;
	}

	public void setDevise(String devise) {
		devise = devise;
	}

	public void setIdFrais(Integer id)
	{
		idFrais = id;
	}

	public Integer getIdFrais()
	{
		return idFrais;
	}
}