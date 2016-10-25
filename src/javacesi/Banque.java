package javacesi;

import java.util.ArrayList;

public class Banque extends Etablissement
{
    private String designation;

    public Banque()
    {
        super();
    }

    public Banque(String designation)
    {
        this.designation = designation;
    }

    public void SetDesignation(String designation)
    {
        this.designation = designation;
    }

    public String GetDesignation()
    {
        return designation;
    }
}
