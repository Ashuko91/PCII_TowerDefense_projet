import javax.swing.*;

import src.Modele.*;
import src.Affiche.*;
import src.Controle.*;

import java.awt.*;

public class Main {
    public static void main(String[] args){
        long startTime = System.nanoTime();

        Grille grille = new Grille(20, 20);
        Etat etat = new Etat();
        Affiche vue = new Affiche(grille, etat);
        Controleur boutons = new Controleur(vue, etat);
        MoveCitoyen cit = new MoveCitoyen(vue, etat, grille);
        MoveMonstre mst = new MoveMonstre(vue, etat, grille);
        ApparitionMonstre appMst = new ApparitionMonstre(vue, etat, grille);

        // Creation de l'objet JFRAME
        JFrame fenetre = new JFrame("Jeu");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel legende = new JLabel("<html><br> <table> <tr> <td> " +
                "<font size = 5> <b><u>Légende</u></b>: </font> </td>" +
                " <td> <font color='blue' size = 5>Chasseur</font> </td> | " +
                "  <td> <font color='#ffcc00' size = 5>Citoyen</font> </td> | " +
                "<td> <font color ='red' size = 5>Monstre</font> </td> | " +
                "  <td> <font color='green' size = 5>Tours défensifs</font> </td> |  " +
                "<td> <font color ='gray' size = 5>Base</font> </td>" +
                "</tr> </table> </html>");

        // On donne une dimension initiale à la fenètre
        fenetre.add(vue);
        fenetre.add(boutons, BorderLayout.EAST);
        fenetre.add(legende, BorderLayout.SOUTH);
        fenetre.addMouseListener(boutons);

        // Lancement des threads des monstres et des citoyens
        cit.start();
        mst.start();
        appMst.start(); //apparitions automatiques des monstres

        // On place le JPanel dans la JFrame
        fenetre.pack();

        // On rend la fenetre visible
        fenetre.setVisible(true);

        /*
        if(etat.getBase().getPv()<=0) {
            long endTime = System.nanoTime();
            long timeElapsed = endTime - startTime;
            JFrame gameOver = new JFrame("GAME OVER");
            gameOver.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel survie = new JLabel("Vous avez survecu: " + timeElapsed/1000000000 + " secondes");

            gameOver.add(survie, BorderLayout.CENTER);
        }*/

    }
}
