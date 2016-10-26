package javacesi;


import Controllers.Connexion;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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

    public ClientBanque connecterUtilisateur(HttpServletRequest request, HttpServletResponse resp ) {
        /* Récupération des champs du formulaire */
        String nom = getValeurChamp( request, CHAMP_NOM );
        String prenom = getValeurChamp( request, CHAMP_PRENOM );
        String relativeWebPath = "outputs/banque.xml";
        String absoluteDiskPath = request.getServletContext().getRealPath(relativeWebPath);
        ClientBanque utilisateur = new ClientBanque();

        /* Validation du champ nom. */
        try {
            validationNom( nom, prenom, absoluteDiskPath );
        } catch ( Exception e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }

        /* Initialisation du résultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succès de la connexion.";
        } else {
            resultat = "Échec de la connexion.";
        }

        return utilisateur;
    }

    /**
     * Valide le nom et prénom saisis.
     */
    private void validationNom( String nom, String prenom, String abs ) throws Exception {
        if ((nom != null) && (prenom != null))
        {

            ArrayList<Agence> agxml = new Parse().parseAgence(abs);

            ArrayList<ClientBanque> clientxml = new ArrayList<ClientBanque>();
            for(int j = 0; j<agxml.size(); j++)
            {
                clientxml.addAll(agxml.get(j).getClients());
            }
            Boolean trouve = false;
            for(int i = 0; i< clientxml.size(); i++)
            {
                if (!(nom.equals(clientxml.get(i).getNom())) && !(prenom.equals(clientxml.get(i).getPrenom())))
                {
                    if (trouve == false)
                    {
                        throw new Exception( "Nom/Prénom incorrects, merci de saisir à nouveau vos identifiants" );
                    }
                }
                else
                {
                    trouve = true;
                }
            }
            if (trouve == false)
            {
                throw new Exception( "Nom/Prénom incorrects, merci de saisir à nouveau vos identifiants" );
            }
        }
        else
        {
            throw new Exception( "Les champs sont obligatoires !" );

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