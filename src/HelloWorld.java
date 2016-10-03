import javacesi.Coffre;
import javacesi.Donnees;

/**
 * Created by Amanite on 14/09/2016.
 */
public class HelloWorld {

    public static void main(String args[])
    {
        Donnees db = new Donnees();

        System.out.println("--- Banque en ligne ---");

        for(Coffre coffre : db.tousLesCoffres)
        {
            coffre.afficheCoffre();
            coffre.afficheOperations();
            System.out.println();
        }
    }
}
