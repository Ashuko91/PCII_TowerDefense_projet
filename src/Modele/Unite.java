package src.Modele;

import java.util.Random;

/**
 * Classe abstraite qui permet de créer un chasseur, un citoyen ou un monstre
 */
abstract class Unite {

    /* Attributes */
    protected int pv; //points de vie de chaque personnage
    protected int position_x; //position en x du personnage
    protected int position_y; //position en y du personnage

    public Random rand = new Random();
    public int dir; // stock la valeur du random entre 1 et 4 pour faire bouger le citoyen de manière aléatoire
    /*Methods*/

    /**
     * Renvoie les pv de l'unité
     * @return pv
     */
    public int getPv() { //renvoie le point de vie restant
        return pv;
    }

    /**
     * Renvoie l'abscisse de l'unité
     * @return position_x
     */
    public int getPosition_x() { //renvoie la position x du personnage
        return position_x;
    }

    /**
     * Renvoie l'ordonnée de l'unité
     * @return position_y
     */
    public int getPosition_y() { //renvoie la position y du personnage
        return position_y;
    }

    /**
     * Affecte à l'abscisse la position x en argument
     * @param position_x
     */
    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    /**
     * Affecte à l'ordonnée la position y en argument
     * @param position_y
     */
    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }

    /**
     * Modifie la position_y de l'unité pour un déplacement vers le haut
     */
    public void haut(){
        if ((position_y --/2) >0) {
            this.position_y = this.position_y - 1/2;
        }else {
            this.position_y = 1/2;
        }
    }

    /**
     * Modifie la position_y de l'unité pour un déplacement vers le bas
     */
    public void bas() {
        if (position_y++/2 < 20/2 -1){
            this.position_y = this.position_y + 1/2;
        }else {
            this.position_y = 20-1;
        }
    }

    /**
     * Modifie la position_x de l'unité pour un déplacement vers la gauche
     */
    public void gauche(){
        if (position_x--/2 >0){
            this.position_x = this.position_x - 1/2;
        }else {
            this.position_x = 1/2;
        }
    }

    /**
     * Modifie la position_x de l'unité pour un déplacement vers la droite
     */
    public void droite(){
        if (position_x++/2 <20/2 - 1){
            this.position_x = this.position_x + 1/2;
        }else {
            this.position_x = 20-1;
        }
    }

    /**
     * Réduit le nombre de pv par l'entier en argument
     * @param perte
     */
    public void pertePV(int perte){
        this.pv -= perte;
    }

}