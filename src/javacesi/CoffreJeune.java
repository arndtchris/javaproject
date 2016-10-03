package javacesi;

import java.util.List;

/**
 * Created by chris on 03/10/2016.
 */
public class CoffreJeune extends Coffre{

    public CoffreJeune()
    {
        this.decouvert = 0.0;
        this.plafond = 1600.0;
        this.interet = 0.2;
        this.maxRetrait = 0.0;
        this.maxDepot = 100.0;
        this.peutFaireVirement = false;
    }

    public CoffreJeune(int id, String loc, String typec, String types, ClientBanque cl, double montant, List<Operation> lesOperations)
    {
        super(id,loc,typec,types,cl,montant,lesOperations);
    }
}
