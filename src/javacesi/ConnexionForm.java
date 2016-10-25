package javacesi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;

import javax.servlet.http.HttpServletRequest;


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

    public ClientBanque connecterUtilisateur(HttpServletRequest request ) {
        /* Récupération des champs du formulaire */
        String nom = getValeurChamp( request, CHAMP_NOM );
        String prenom = getValeurChamp( request, CHAMP_PRENOM );

        ClientBanque utilisateur = new ClientBanque();

        /* Validation du champ nom. */
        try {
            validationNom( nom, prenom );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        utilisateur.setNom( nom );
        utilisateur.setPrenom( prenom );

        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la connexion.";
        } else {
            resultat = "Échec de la connexion.";
        }

        return utilisateur;
    }

    /**
     * Valide l'adresse email saisie.
     */
    private void validationNom( String nom, String prenom ) throws Exception {
        ArrayList<ClientBanqueXML> clxml = new ArrayList<ClientBanqueXML>();
        ArrayList<Agence> agxml = new Parse().parseAgence("outputs/banques.xml");


        for(int i=0; i<clxml.size(); i++)
        {
            //System.out.println(clxml.get(i).nom.toString());
            //System.out.println(clxml.get(i).prenom.toString());

            if (!(nom.equals(clxml.get(i).nom.toString())) && !(prenom.equals(clxml.get(i).prenom.toString())))
            {
            throw new Exception( "Nom/Prénom incorrects, merci de saisir à nouveau vos identifiants" );
            }
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationPrenom( String prenom ) throws Exception {
        if ( prenom != null ) {
            if ( prenom.length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
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