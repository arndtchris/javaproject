package javacesi;

import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Mickaël Cimbaluria on 05/10/2016.
 */
public class Connexion {

    public static void main(String[] args){

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
        JLabel titre = new JLabel("Bienvenue, veuillez vous identifier svp");
        pan.add(titre);

        //Création des champs Nom et Prénom
        //Nom
        JLabel nom = new JLabel("Nom : ");
        JTextField nomtxt = new JTextField();
        pan.add(nom);
        pan.add(nomtxt);


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

               JFrame j = new JFrame();
                JPanel pan2 = new JPanel();
                j.setSize(500, 100);
                JLabel lab = new JLabel("Bravo !!!! Vous avez cliqué !!!!");
                pan2.add(lab);
                lab.setVisible(true);
                j.setVisible(true);
                j.setLocationRelativeTo(null);
                j.setContentPane(pan2);
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
    }
}
