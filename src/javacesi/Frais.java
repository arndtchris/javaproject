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
	private Date DateAnnee;
	private Float Montant;
	private String Description;

	public Frais() {
	}

	public Frais(Integer aIdFrais, Date aDateAnnee, Float aMontant, String aDescription) {
		this.IdFrais = aIdFrais;
		this.DateAnnee = aDateAnnee;
		this.Montant = aMontant;
		this.Description = aDescription;
	}

	public void SetIdFrais(Integer IdFrais) {
		this.IdFrais = IdFrais;
	}

	public Integer GetIdFrais() {
		return IdFrais;
	}

	public void SetDateAnnee(Date aDateAnnee) {
		this.DateAnnee = aDateAnnee;
	}

	public Date GetDateAnnee() {
		return DateAnnee;
	}

	public void SetMontant(Float aMontant) {
		this.Montant = aMontant;
	}

	public Float GetMontant() {
		return Montant;
	}

	public void SetDescription(String aDescription) {
		this.Description = aDescription;
	}

	public String GetDescription() {
		return Description;
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