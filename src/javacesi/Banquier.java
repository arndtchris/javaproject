package javacesi;

/**
 * Created by chris on 03/10/2016.
 */
public class Banquier extends Individu implements ICrud{

    public Banquier(int id, String nm, String pn, Agence agr) {
        super(id,nm,pn,agr);
    }

    public Banquier()
    {
        super();
    }

    public void addCoffreToClient(ClientBanque client, Coffre c)
    {
        client.addCoffre(c);
    }


    @Override
    public void Create() {

    }

    @Override
    public void Read() throws AlsCustomException {

    }

    @Override
    public void Update() throws AlsCustomException {

    }

    @Override
    public void Delete() throws AlsCustomException {

    }
}
