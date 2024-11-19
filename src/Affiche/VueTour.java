package src.Affiche;

import src.Modele.Tour;

import java.awt.*;

public class VueTour {

    /**
     * Dessine l'ensemble des tours de la liste de l'état
     * @param g, Graphics
     */
    public static void AfficheTour(Graphics g, int x, int y) {
        g.setColor(Color.GREEN);
        // Modification des coordonnées obtenues via le MouseClick
        y -= 25;
        x = x/40;
        y = y/40;
        // Vérification des coordonnées et de la case séléctionnée, cette case ne doit pas contenir de batiment
        if (x < 20 && y < 20 && Affiche.grille.getCase(y, x).getBatiment() == null) {
            g.fillRect(x*40 + 20, y*40 + 20, 10, 10);
            if(Affiche.grille.getCase(y, x).getBatiment() == null) {
                Affiche.grille.getCase(y, x).setBatiment(new Tour(x, y));
            }
        }
    }
}
