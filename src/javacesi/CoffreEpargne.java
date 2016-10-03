package javacesi;

import java.util.List;

/**
 * Created by chris on 03/10/2016.
 */
public class CoffreEpargne extends Coffre {


    public CoffreEpargne()
    {
        this.decouvert = 0.0;
        this.interet = 0.15;
        this.maxRetrait = 0.0;
        this.peutFaireVirement = false;
    }

    public CoffreEpargne(int id, String loc, String typec, String types, ClientBanque cl, double montant, List<Operation> lesOperations)
    {
        super(id,loc,typec,types,cl,montant,lesOperations);
    }
}
