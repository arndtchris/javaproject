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
    public void Create(int id) {

    }

    @Override
    public <T> void Read(T object) throws AlsCustomException {

    }

    @Override
    public <T> void Update(T object) throws AlsCustomException {

    }

    @Override
    public void Delete() throws AlsCustomException {

    }
}
