package src.Affiche;

import java.awt.Color;
import java.awt.Graphics;

import src.Modele.*;

public class VueBase{

    //Coordonnees de la Base, situee au milieu du terrain
    public static final int Xbase = Affiche.Xcase/2;
    public static final int Ybase = Affiche.Ycase/2;

    /**
     * Dessine la base de l'état
     * @param g, Graphics
     */
    public static void AfficheBase(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(Xbase*40 , Ybase*40 , 10, 10);
        Affiche.grille.getCase(Ybase, Xbase).setBatiment(new Base(Xbase, Ybase));
    }

}
