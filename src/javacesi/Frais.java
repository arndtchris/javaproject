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

	private Integer IdFrais;
	private String TypeCoffre;
	private String PeriodeLocation;
	private String PrixPeriode;
	private String Devise;

	public Frais() {
	}

	public Frais(FraisXML f)
	{
		this.TypeCoffre = f.TypeCoffre;
		this.Devise = f.Devise;
		this.PeriodeLocation = f.PeriodeLocation;
		this.PrixPeriode = f.PrixPeriode;
	}

	public Frais(Integer aIdFrais, String typeCoffre, String periodeLocation, String prixPeriode,String devise) {
		this.IdFrais = aIdFrais;
		this.TypeCoffre = typeCoffre;
		this.PeriodeLocation = periodeLocation;
		this.PrixPeriode = prixPeriode;
		this.Devise = devise;
	}

	public void SetIdFrais(Integer IdFrais) {
		this.IdFrais = IdFrais;
	}

	public Integer GetIdFrais() {
		return IdFrais;
	}

	public void SetTypeCoffre(String typeCoffre) {
		this.TypeCoffre = typeCoffre;
	}

	public String GetTypeCoffre() {
		return this.TypeCoffre;
	}

	public void SetPeriodeLocation(String periode) {
		this.PeriodeLocation = periode;
	}

	public String GetPeriodeLocation()
	{
		return this.PeriodeLocation;
	}

	public String GetPrixPeriode() {
		return this.PrixPeriode;
	}

	public void SetDevise(String dev) {
		this.Devise = dev;
	}

	public String GetDevise() {
		return this.Devise;
	}

	@Override
	public void Create() {

	}

	@Override
	public void Read() throws AlsCustomException {
		if (this.IdFrais == 0)
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
		if (this.IdFrais == 0)
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
		if (this.IdFrais == 0)
		{
			// throw our custom exception
			throw new AlsCustomException("Ce frais n'existe pas");
		}
		else
		{
			System.out.println("Frais supprimé");
		}
	}
}