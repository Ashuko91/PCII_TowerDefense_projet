package src.Modele;

/**
 * Classe qui permet la gestion de la base, hérite de la classe Batiment
 */
public class Base extends Batiment {

    //Base de points de vie de la base
    public static final int BASE_PV = 1000;

    //Creation de la base avec ses coordonnees X et Y et sa base de PV
    public Base(int X, int Y) {
        this.PV = BASE_PV;
        this.X = X;
        this.Y = Y;
    }
}
