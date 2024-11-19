package src.Modele;

/**
 * Classe permettant d'initialisé une grille de cases
 */
public class Grille {
    private int taillex, tailley;
    private Case[][] tabCase;

    /*
    | Constructeur
    | @param x et y le nombre de lignes et de colonnes
     */
    public Grille(int x, int y) {
        taillex = x;
        tailley = y;

        tabCase = new Case[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++)
                tabCase[i][j] = new Case(i, j);
        }
    }

    /**
     * Renvoie la case aux coordonnées (x,y)
     * @param x, l'abscisse
     * @param y, l'ordonnée
     * @return tabCase[x][y]
     */
    public Case getCase(int x, int y) {
        return this.tabCase[x][y];
    }

    /**
     * Renvoie le tableau de Cases de la grille
     * @return tabCase
     */
    public Case[][] getTabCase(){
        return this.tabCase;
    }

    /**
     * Renvoie la taille de la grille définie en abscisse
     * @return taillex
     */
    public int getTailleX(){
        return this.taillex;
    }

    /**
     * Renvoie la taille de la grille définie en ordonnée
     * @return tailley
     */
    public int getTailleY(){
        return this.tailley;
    }
}
