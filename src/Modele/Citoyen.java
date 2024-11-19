package src.Modele;

/**
 * Classe qui permet la gestion d'un citoyen, hérite de la classe Unite
 */
public class Citoyen extends Unite {

    /*Attributes*/
    private int money; //argent obtenu grace aux citoyens

    /*Constructor*/
    public Citoyen(int X, int Y){
        this.pv = 200; //initialisation des pv d'un citoyen au debut
        this.money = 0; //initialisation du compte de chaque citoyen
        this.position_x = X;
        this.position_y = Y;
    }

    /*Methods*/

    /**
     * Renvoie l'argent que possède le citoyen
     * @return money
     */
    public int getMoney() {
        return money;
    }

    /**
     * Ajoute de l'argent au compte du citoyen
     */
    public void addMoney(){
        this.money +=5;
    }

    /**
     * Reitre l'argent au compte du citoyen
     */
    public void removeMoney(){
        this.money = 0;
    }

    /**
     * Direction aléatoire du citoyen
     */
    public void MovementAleat() {
        dir = rand.nextInt(4) + 1;
        switch (dir) {
            case 1:
                this.haut();
                break;
            case 2:
                this.bas();
                break;
            case 3:
                this.gauche();
                break;
            case 4:
                this.droite();
                break;
        }
    }
}
