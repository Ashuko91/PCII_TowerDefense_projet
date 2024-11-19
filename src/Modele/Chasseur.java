package src.Modele;

/**
 * Classe qui permet la gestion d'un chasseur, hérite de la classe Unite
 */
public class Chasseur extends Unite {

    /*Attributes*/
    private int pa; // Points d'attaque

    /*Constructor*/
    public Chasseur(int X, int Y){
        this.pv = 50; //initialisation des pv d'un chasseur au debut
        this.pa = 30; //initialisation des points d'attaque
        this.position_x = X;
        this.position_y = Y;
    }

    /*Methods*/

    //renvoie les points d'attaque du chasseur
    public int getpa(){
        return this.pa;
    }
}
