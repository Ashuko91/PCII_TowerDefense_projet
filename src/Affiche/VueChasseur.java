package src.Affiche;

import java.awt.Color;
import java.awt.Graphics;

import src.Modele.*;

public class VueChasseur {

    public static int Xchasseur = VueBase.Xbase;
    public static int Ychasseur = VueBase.Ybase-1;

    /**
     * Créer le chasseur initial
     */
    public static void initChasseur(){
        //Intialisation du chasseur dans la grille et dans l'état
        Affiche.grille.getCase(Xchasseur, Ychasseur).setChasseur(new Chasseur(Xchasseur, Ychasseur));
        Affiche.etat.addChasseur(new Chasseur(Xchasseur, Ychasseur));
    }

    /**
     * Dessine l'ensemble des chasseurs de la liste de l'état
     * @param g, Graphics
     */
    public static void afficheChasseur(Graphics g){
        g.setColor(Color.BLUE);
        for (int i = 0; i <Affiche.etat.getTailleChass();i++){
            g.fillRect(Affiche.etat.getiChass(i).getPosition_x()*40+25, Affiche.etat.getiChass(i).getPosition_y() * 40, 5, 5);
        }
    }
}
