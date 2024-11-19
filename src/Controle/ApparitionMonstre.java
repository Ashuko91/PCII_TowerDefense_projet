package src.Controle;

import src.Modele.*;
import src.Affiche.*;
import java.util.Random;

/**
 * Classe de gestion de l'apparition aléatoire des monstres
 */
public class ApparitionMonstre extends Thread{
    private Etat etat;
    private Affiche affiche;
    private Grille grille;

    public static Random rand = new Random();

    /*Variable qui va stocker la valeur aléatoire entre 1 et 4*/
    public int spawn = 0;

    public ApparitionMonstre(Affiche a, Etat e, Grille g) {
        this.etat = e;
        this.affiche = a;
        this.grille = g;
    }

    /**
     * Permet de créer un monstre dans les limitations de la carte
     */
    public void Apparition() {
        spawn = rand.nextInt(5);
        switch(spawn) {
            case 1:
                //Créer aléatoirement sur la ligne du haut
                affiche.creerMonstre(0,rand.nextInt(20));
                break;
            case 2:
                //Créer aléatoirement sur la ligne de gauche
                affiche.creerMonstre(rand.nextInt(20), 0);
                break;
            case 3:
                //Créer aléatoirement sur la ligne de droite
                affiche.creerMonstre(19, rand.nextInt(20));
                break;
            case 4:
                //Créer aléatoirement sur la ligne du bas
                affiche.creerMonstre(rand.nextInt(20), 19);
                break;
        }
    }

    //Tant que la base n'est pas détruite, un monstre apparait à intervalle régulier
    @Override
    public void run() {
        while(etat.getBase().getPv()>0) {
            try {
                Thread.sleep(15000);
                this.Apparition();
                this.affiche.repaint();
                this.affiche.revalidate();
            }catch (Exception e) { e.printStackTrace(); }
        }
    }
}
