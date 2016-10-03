package javacesi;

import java.util.List;

/**
 * Created by chris on 03/10/2016.
 */
public class CoffreCourant extends Coffre{

    public CoffreCourant()
    {
        this.decouvert = -100.0;
        this.maxRetrait = 1000.0;
        this.peutFaireVirement = true;
    }

    public CoffreCourant(int id, String loc, String typec, String types, ClientBanque cl, double montant, List<Operation> lesOperations)
    {
        super(id,loc,typec,types,cl,montant,lesOperations);
    }
}
