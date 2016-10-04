package javacesi;

import com.sun.deploy.util.SessionState;

import java.util.List;

/**
 * Created by Mickaël Cimbaluria on 03/10/2016.
 */
public class Etablissement implements ICrud
{

    private int idEtab;
    private String nomEtab;
    private String adresseEtab;
    private List<ClientBanque> clients;

    public Etablissement(){}

    public Etablissement(int id, String name, String adress, List<ClientBanque> cl)
    {
        this.idEtab = id;
        this.nomEtab = name;
        this.adresseEtab = adress;
        this.clients = cl;
    }

    public void setIdEtab(int id){this.idEtab = id;}
    public void setNom(String nom){this.nomEtab = nom;}
    public void setAdresse(String adresse){this.adresseEtab = adresse;}
    public void addClient(ClientBanque client){this.clients.add(client);}



    public int getIdEtab(){return this.idEtab;}

    public String getNom(){return this.nomEtab;}

    public List<ClientBanque> getListClient(){return this.clients;}

    public String getAdresse(){return this.adresseEtab;}

    @Override
    public void Create() {

    }

    @Override
    public void Read() {

    }

    @Override
    public void Update() {

    }

    @Override
    public void Delete() {

    }

}

