package javacesi;

import com.sun.deploy.util.SessionState;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mickaël Cimbaluria on 03/10/2016.
 */
public class Etablissement implements ICrud
{

    private int idEtab;
    private String nomEtab;
    private String adresseEtab;
    private ArrayList<ClientBanque> clients;

    public Etablissement(){
        this.clients = new ArrayList<ClientBanque>();
    }

    public Etablissement(int id, String name, String adress, ArrayList<ClientBanque> cl)
    {
        this.idEtab = id;
        this.nomEtab = name;
        this.adresseEtab = adress;
        this.clients = cl;
    }

    public void setIdEtab(int id){this.idEtab = id;}
    public void addClient(ClientBanque client){this.clients.add(client);}
    public List<ClientBanque> getClients(){return this.clients;}


    public String getAdresseEtab() {return adresseEtab;}

    public void setAdresseEtab(String adresseEtab) {this.adresseEtab = adresseEtab;}

    public void setNomEtab(String nom){this.nomEtab = nom;}

    public String getNomEtab(){return nomEtab;}

    public int getIdEtab(){return this.idEtab;}

    @Override
    public void Create() {

    }

    @Override
    public void Read() throws AlsCustomException {
        if (this.idEtab == 0)
        {
            // throw our custom exception
            throw new AlsCustomException("L'établissement n'existe pas");
        }
        else
        {
            System.out.println("je décrit l'établissement");
        }
    }

    @Override
    public void Update() throws AlsCustomException {
        if (this.idEtab == 0)
        {
            // throw our custom exception
            throw new AlsCustomException("L'établissement n'existe pas");
        }
        else
        {
            System.out.println("Établissement modifié");
        }
    }

    @Override
    public void Delete() throws AlsCustomException {
        if (this.idEtab == 0)
        {
            // throw our custom exception
            throw new AlsCustomException("L'établissement n'existe pas");
        }
        else
        {
            System.out.println("Établissement supprimé");
        }
    }
}

