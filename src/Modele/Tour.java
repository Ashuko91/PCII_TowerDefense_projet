package src.Modele;

/**
 * Classe qui permet la gestion d'une tour, hérite de la classe Batiment
 */
public class Tour extends Batiment {

    //Base de points de vie des Tours
    public static final int DEFAULT_TOWER_PV = 200;
    //Points d'attaque des Tours
    public static final int PA = 30;

    //Création d'une Tour avec ses coordonnees
    public Tour(int X, int Y) {
        this.PV = DEFAULT_TOWER_PV;
        this.Y = Y;
        this.X = X;
    }
}
