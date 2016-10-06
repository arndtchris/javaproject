package javacesi;

/**
 * Created by Amanite on 06/10/2016.
 */
public class ReservationXML {

    private ClientBanque client;
    private Coffre coffre;

    public ReservationXML(Coffre coffre, ClientBanque client)
    {
        this.client = client;
        this.coffre = coffre;
    }

    public ClientBanque getClient(){ return this.client;}
    public Coffre getCoffre() {return this.coffre;}

    public void setCoffre(Coffre coffre){this.coffre = coffre;}
    public void setClient(ClientBanque client){this.client = client;}
}
