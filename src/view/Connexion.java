package view;

import javacesi.*;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;


/**
 * Created by Mickaël Cimbaluria on 05/10/2016.
 */
public class Connexion {

    protected ClientBanqueXML clconnecte = new ClientBanqueXML();

    public ClientBanqueXML AuthentifieClient(){


        JFrame fenetre = new JFrame();

        //Définit un titre pour notre fenêtre
        fenetre.setTitle("Connexion");

        //Définit sa taille : 400 pixels de large et 100 pixels de haut
        fenetre.setSize(800, 400);

        //On créé le panel pour afficher nos composants
        JPanel pan = new JPanel();

        //On créé un grid layout pour que les composants soient mieux placés
        GridLayout gl = new GridLayout(10,10);
        pan.setLayout(gl);

        //On créé le label de bienvenue
        JLabel titre = new JLabel("Bienvenue, veuillez vous identifier svp",JLabel.CENTER);
        pan.add(titre);

        //Création des champs Nom et Prénom

        //Nom
        JLabel nom = new JLabel("Nom : ", JLabel.CENTER);
        JTextField nomtxt = new JTextField();
        pan.add(nom);
        pan.add(nomtxt);

        //Nom
        JLabel prenom = new JLabel("Prénom : ",JLabel.CENTER);
        JTextField prenomtxt = new JTextField();
        pan.add(prenom);
        pan.add(prenomtxt);

        //Pas beau, mais pour sauter une ligne ...
        JLabel vide = new JLabel(" ");
        pan.add(vide);

        //Bouton "se connecter" et "annuler"
        JButton connect = new JButton("Se connecter");
        JButton annuler = new JButton("Annuler");

        //On ajoute le bouton au panel
        pan.add(connect);
        pan.add(annuler);
        connect.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                //Instanciation de l'agence pour les individus
                Agence agr = new Agence();

                //Instanciation des individus
                ArrayList<ClientBanqueXML> clxml = new ArrayList<ClientBanqueXML>();
                ArrayList<AgenceXML> agxml = new Parse().parseAgence();
                for(int j=0; j<agxml.size(); j++)
                {
                    if ((agxml.get(j).listeClient != null) && (agxml.get(j).listeClient.size() > 0))
                    {
                    clxml.addAll(agxml.get(j).listeClient);
                    }
                }

                boolean trouve = false;

                for(int i=0; i<clxml.size(); i++)
                {
                    //System.out.println(clxml.get(i).nom.toString());
                    //System.out.println(clxml.get(i).prenom.toString());

                    if ((nomtxt.getText().toString().equals(clxml.get(i).nom.toString())) && (prenomtxt.getText().toString().equals(clxml.get(i).prenom.toString())))
                    {
                        JFrame j = new JFrame();
                        JPanel pan2 = new JPanel();
                        j.setSize(500, 100);
                        JLabel lab = new JLabel("Bravo !!!! Vous avez cliqué !!!!");
                        pan2.add(lab);
                        lab.setVisible(true);
                        j.setVisible(true);
                        j.setLocationRelativeTo(null);
                        j.setContentPane(pan2);
                        trouve = true;

                        clconnecte = clxml.get(i);
                    }
                    else
                    {
                        if ((i == clxml.size()-1) || (trouve = false))
                        {
                            JFrame j = new JFrame();
                            JPanel pan3 = new JPanel();
                            j.setSize(500, 100);
                            JLabel lab = new JLabel("Votre mot de passe est erroné, merci de le ressaisir");
                            pan3.add(lab);
                            lab.setVisible(true);
                            j.setVisible(true);
                            j.setLocationRelativeTo(null);
                            j.setContentPane(pan3);
                        }
                    }
                }
            }
        });

        annuler.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                fenetre.dispose();
            }
        });
        //Nous demandons maintenant à notre objet de se positionner au centre
        fenetre.setLocationRelativeTo(null);
        //Termine le processus lorsqu'on clique sur la croix rouge
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Et enfin, la rendre visible
        fenetre.setContentPane(pan);
        pan.setBackground(Color.gray);
        fenetre.setVisible(true);
        return clconnecte;
    }

    public Connexion()
    {

    }
}
