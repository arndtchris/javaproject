import javacesi.Agence;
import javacesi.AgenceXML;
import javacesi.Parse;

import java.util.ArrayList;

/**
 * Created by Amanite on 14/09/2016.
 */
public class HelloWorld {

    public static void main(String args[]) {
        /*Donnees db = new Donnees();

        System.out.println("--- Banque en ligne ---");

        for(Coffre coffre : db.tousLesCoffres)
        {
            coffre.afficheCoffre();
            coffre.afficheOperations();
            System.out.println();
        }

        Coffre example = db.tousLesCoffres.get(0);
        example.setId(0);
        example.Delete();*/

        ArrayList<AgenceXML> agences = new Parse().parseAgence();

        for(int i = 0; i < agences.size(); i++)
        {
            System.out.println(agences.get(i).Adresse);
        }

        /*Console console = System.console();

        if (console == null) {
            System.out.println("Couldn't get Console instance");
            System.exit(0);
        }

        char password[] = console.readPassword("Entrez un mdp :");
        console.printf("Saisie : ", new String(password));*/

    }
}
