package javacesi;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import javacesi.ClientBanque;

public final class ConnexionForm {
    private static final String CHAMP_NOM  = "nom";
    private static final String CHAMP_PRENOM   = "prenom";

    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public ClientBanque connecterUtilisateur( HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String email = getValeurChamp( request, CHAMP_NOM );
        String motDePasse = getValeurChamp( request, CHAMP_PRENOM );

        ClientBanque utilisateur = new ClientBanque();


        return utilisateur;
    }



    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}