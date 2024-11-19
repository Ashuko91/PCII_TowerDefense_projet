package src.Modele;

/**
 * Classe abstraite qui permet de créer une base ou une tour
 */
abstract class Batiment{

    //points de vie d'un batiment a sa creation
    protected int PV;

    //coordonnees du batiment
    protected int Y;
    protected int X;

    //Getters et Setters pour les PV et les coordonnees
    public int getPv() {
        return PV;
    }
    public void setPv(int pV) {
        PV = pV;
    }
    public int getY() {
        return Y;
    }
    public void setY(int y) {
        Y = y;
    }
    public int getX() {
        return X;
    }
    public void setX(int x) {
        X = x;
    }

    //applique la perte de PV d'un batiment lors d'une attaque de monstre
    public void pertePV(int perte) {
        this.PV -= perte;
    }
}
