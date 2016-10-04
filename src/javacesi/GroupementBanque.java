package javacesi;

import java.util.ArrayList;

public class GroupementBanque implements ICrud
{
    private ArrayList<Banque> listeBanque;
    private String designation;

    public GroupementBanque()
    {
        listeBanque = new ArrayList<Banque>();
    }

    public GroupementBanque(String designation)
    {
        this.designation = designation;
        listeBanque = new ArrayList<Banque>();
    }

    public void SetDesignation(String designation)
    {
        this.designation = designation;
    }

    public String GetDesignation()
    {
        return designation;
    }

    public void AddBanque(Banque b)
    {
        listeBanque.add(b);
    }

    public Banque GetBanque(int i)
    {
        if(i >= listeBanque.size() || i < 0)
            return null;
        else
            return listeBanque.get(i);
    }

    public ArrayList<Banque> GetListeBanque()
    {
        return listeBanque;
    }

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
