package src.Modele;
import src.Affiche.*;

/**
 * Classe qui permet la gestion d'un monstre, hérite de la classe Unite
 */
public class Monstre extends Unite {

    /*Attributes*/
    private int pa; // Points d'attaque

    /*Constructor*/
    public Monstre(int X, int Y){
        this.pv = 50; //initialisation des pv d'un monstre
        this.pa = 50; //initialisation des pa d'un monstre
        this.position_x = X;
        this.position_y = Y;
    }

    /*Methods*/

    /**
     * Renvoie les points d'attaques du monstre
     * @return pa
     */
    public int getpa(){
        return this.pa;
    }

    /**
     * Permet de gérer le mouvement du monstre sur l'abscisse
     */
    public void MovementMstX() {
        if (this.position_x > VueBase.Xbase){
            this.gauche();
        }else if (this.position_x < VueBase.Xbase){
            this.droite();
        }else {
            this.position_x = 10;
        }
    }

    /**
     * Permet de gérer le mouvement du monstre sur l'ordonnée
     */
    public void MovementMstY() {
        if (this.position_y>VueBase.Ybase){
            this.haut();
        }else if (this.position_y<VueBase.Ybase){
            this.bas();
        }else{
            this.position_x = 10;
        }
    }

    /**
     * Permet de générer un mouvement aléatoire du monstre
     * se dirigeant vers la base
     */
    public void MovementMst(){
        dir = rand.nextInt(2)+1;
        switch(dir){
            case 1:
                MovementMstX();
                break;
            case 2:
                MovementMstY();
                break;
        }
    }
}
