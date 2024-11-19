package src.Affiche;

import java.awt.Color;
import java.awt.Graphics;

import src.Modele.Etat;
import src.Modele.Grille;
import src.Modele.Monstre;

public class VueMonstre{

    public static int Xmst = 0;
    public static int Ymst = 0;

    /**
     * Créer le monstre initial
     */
    public static void initMonstre() {

        /*Intialisation du monstre dans la grille et dans l'état*/
        Affiche.grille.getCase(Xmst, Ymst).setMonstre(new Monstre(Xmst, Ymst));
        Affiche.etat.addMonstre(new Monstre(Xmst, Ymst));
    }

    /**
     * Dessine l'ensemble des monstres de la liste de l'état
     * @param g, Graphics
     */
    public static void afficheMonstre(Graphics g){
        g.setColor(Color.RED);
        for (int i = 0; i < Affiche.etat.getTailleMst();i++){
            g.fillRect(Affiche.etat.getiMst(i).getPosition_x()*40+25, Affiche.etat.getiMst(i).getPosition_y() * 40+12, 5, 5);
        }
    }
}
