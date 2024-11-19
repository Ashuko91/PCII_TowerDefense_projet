package src.Affiche;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import src.Modele.*;

public class VueCitoyen {

    public static int Xcit1;
    public static int Ycit1;
    public static int Xcit2;
    public static int Ycit2;
    public static int Xcit3;
    public static int Ycit3;
    public static int Xcit4;
    public static int Ycit4;

    /**
     * Créer les citoyens initiaux
     */
    public static void initCitoyens() {

        // Position aléatoires des citoyens
        Random random = new Random();
        Xcit1 = random.nextInt(10) + 5;
        Ycit1 = random.nextInt(10) + 5;
        Xcit2 = random.nextInt(10) + 5;
        Ycit2 = random.nextInt(10) + 5;
        Xcit3 = random.nextInt(10) + 5;
        Ycit3 = random.nextInt(10) + 5;
        Xcit4 = random.nextInt(10) + 5;
        Ycit4 = random.nextInt(10) + 5;

        //Intialisation des citoyens dans la grille et dans l'état
        Affiche.grille.getCase(Xcit1, Ycit1).setCitoyen(new Citoyen(Xcit1, Ycit1));
        Affiche.etat.addCitoyen(new Citoyen(Xcit1, Ycit1));

        Affiche.grille.getCase(Xcit2, Ycit2).setCitoyen(new Citoyen(Xcit2, Ycit2));
        Affiche.etat.addCitoyen(new Citoyen(Xcit2, Ycit2));

        Affiche.grille.getCase(Xcit3, Ycit3).setCitoyen(new Citoyen(Xcit3, Ycit3));
        Affiche.etat.addCitoyen(new Citoyen(Xcit3, Ycit3));

        Affiche.grille.getCase(Xcit4, Ycit4).setCitoyen(new Citoyen(Xcit4, Ycit4));
        Affiche.etat.addCitoyen(new Citoyen(Xcit4, Ycit4));
    }

    /**
     * Dessine l'ensemble des citoyens de la liste de l'état
     * @param g, Graphics
     */
    public static void afficheCitoyen(Graphics g){
        g.setColor(Color.ORANGE);
        for (int i = 0; i < Affiche.etat.getTailleCit();i++){
            g.fillRect(Affiche.etat.getiCit(i).getPosition_x()*40+12, Affiche.etat.getiCit(i).getPosition_y() * 40+12, 5, 5);
        }
    }

}
