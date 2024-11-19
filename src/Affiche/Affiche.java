package src.Affiche;

import src.Modele.*;
import javax.swing.*;
import java.awt.*;


/**
 * Classe affichage qui dessine le jeu en fonction de la grille et de l'état du du jeu
 */
public class Affiche extends JPanel {

    protected static Grille grille;
    protected static Etat etat;

    //Largeur et Hauteur de la Grille
    public static final int LARG = 800;
    public static final int HAUT = 800;

    //Dimensions de la Grille, en cases
    public static final int Xcase = 20;
    public static final int Ycase = 20;

    public Affiche(Grille g, Etat e){
        grille = g;
        etat = e;
        setPreferredSize(new Dimension(LARG, HAUT));
        initUnite();
    }

    /**
     * Initialise les unités de base
     */
    public void initUnite() {
        // Initialisatin du chasseur
        VueChasseur.initChasseur();

        // Initialisation des 4 citoyens
        VueCitoyen.initCitoyens();

        // Initialisation d'un monstre
        VueMonstre.initMonstre();
    }

    //Creation des cases de la Grille 
    public void creerCarre(Graphics g, int x, int y){
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 30, 30);
    }

    //Ajout de l'objet Tour dans le tableau de Tours d'Etat
    public void ajoutTour(int x, int y) {
        etat.addTour(new Tour(x, y));
    }


    /**
     * Créer un nouvel objet chasseur et l'ajoute dans la grille et la liste
     * @param x, l'abscisse
     * @param y, l'ordonnée
     */
    public void creerChasseur(int x, int y){
        // Modification des coordonnées obtenues via le MouseClick
        y -= 25;
        x = x/40;
        y = y/40;
        // Vérification des coordonnées et de la case séléctionnée,
        // cette case ne doit pas comporter de chasseur
        if(x<20 && y < 20 && grille.getCase(y, x).getChasseur() == null){
            grille.getCase(y, x).setChasseur(new Chasseur(x, y));
            etat.addChasseur(new Chasseur(x, y));
        }
    }

    /**
     * Créer un nouvel objet citoyen et l'ajoute dans la grille et la liste
     * @param x, l'abscisse
     * @param y, l'ordonnée
     */
    public void creerCitoyen(int x, int y){
        // Modification des coordonnées obtenues via le MouseClick
        y -= 25;
        x = x/40;
        y = y/40;
        // Vérification des coordonnées et de la case séléctionnée,
        // cette case ne doit pas comporter de citoyen
        if(x<20 && y < 20 && grille.getCase(y, x).getCitoyen() == null){
            grille.getCase(y, x).setCitoyen(new Citoyen(x, y));
            etat.addCitoyen(new Citoyen(x, y));
        }
    }

    /**
     * Créer un nouvel objet monstre et l'ajoute dans la grille et la liste
     * @param x, l'abscisse
     * @param y, l'ordonnée
     */
    public void creerMonstre(int x, int y){
        // Vérification des coordonnées et de la case séléctionnée, cette case doit être vide
        if(x<20 && y < 20 && grille.getCase(y, x).getMonstre() == null){
            grille.getCase(y, x).setMonstre(new Monstre(x, y));
            etat.addMonstre(new Monstre(x, y));
        }
    }

    /**
     * Déplace le chasseur aux coordonnées (x,y) vers le haut
     * en modifiant ses coordonnées dans la grille et dans la liste
     * @param x
     * @param y
     */
    public void hautChasseur(int x, int y){
        y -= 25;
        x = x/40;
        y = y/40;
        if(x<20 && y < 20 && grille.getCase(x, y-1).getChasseur() == null){
            Chasseur c = grille.getCase(x, y).getChasseur();
            grille.getCase(x, y - 1).setChasseur(c);
            grille.getCase(x, y).setChasseur(null);
            for (Chasseur ch : etat.listChasseur) {
                if (ch.getPosition_x() == x && ch.getPosition_y() == y) {
                    ch.setPosition_x(x);
                    ch.setPosition_y(y - 1);
                }
            }
            for (int i = 0; i < etat.getTailleChass(); i++) {
                if (etat.getiChass(i).getPosition_x() == x && etat.getiChass(i).getPosition_y() == y) {
                    etat.getiChass(i).haut();
                }
            }
        }
    }

    /**
     * Déplace le chasseur aux coordonnées (x,y) vers le bas
     * en modifiant ses coordonnées dans la grille et dans la liste
     * @param x
     * @param y
     */
    public void basChasseur(int x, int y){
        y -= 25;
        x = x/40;
        y = y/40;
        if(x<20 && y < 20 && grille.getCase(x, y+1).getChasseur() == null){
            Chasseur c = grille.getCase(x, y).getChasseur();
            grille.getCase(x, y + 1).setChasseur(c);
            grille.getCase(x, y).setChasseur(null);
            for (Chasseur ch : etat.listChasseur) {
                if (ch.getPosition_x() == x && ch.getPosition_y() == y) {
                    ch.setPosition_x(x);
                    ch.setPosition_y(y + 1);
                }
            }
            for (int i = 0; i < etat.getTailleChass(); i++) {
                if (etat.getiChass(i).getPosition_x() == x && etat.getiChass(i).getPosition_y() == y) {
                    etat.getiChass(i).bas();
                }
            }
        }
    }

    /**
     * Déplace le chasseur aux coordonnées (x,y) vers le gauche
     * en modifiant ses coordonnées dans la grille et dans la liste
     * @param x
     * @param y
     */
    public void gaucheChasseur(int x, int y){
        y -= 25;
        x = x/40;
        y = y/40;
        if(x<20 && y < 20 && grille.getCase(x-1, y).getChasseur() == null){
            Chasseur c = grille.getCase(x, y).getChasseur();
            grille.getCase(x - 1, y).setChasseur(c);
            grille.getCase(x, y).setChasseur(null);
            for (Chasseur ch : etat.listChasseur) {
                if (ch.getPosition_x() == x && ch.getPosition_y() == y) {
                    ch.setPosition_x(x - 1);
                    ch.setPosition_y(y);
                }
            }
            for (int i = 0; i < etat.getTailleChass(); i++) {
                if (etat.getiChass(i).getPosition_x() == x && etat.getiChass(i).getPosition_y() == y) {
                    etat.getiChass(i).gauche();
                }
            }
        }
    }

    /**
     * Déplace le chasseur aux coordonnées (x,y) vers le droite
     * en modifiant ses coordonnées dans la grille et dans la liste
     * @param x
     * @param y
     */
    public void droiteChasseur(int x, int y){
        y -= 25;
        x = x/40;
        y = y/40;
        if(x<20 && y < 20 && grille.getCase(x+1, y).getChasseur() == null){
            Chasseur c = grille.getCase(x, y).getChasseur();
            grille.getCase(x + 1, y).setChasseur(c);
            grille.getCase(x, y).setChasseur(null);
            for (Chasseur ch : etat.listChasseur) {
                if (ch.getPosition_x() == x && ch.getPosition_y() == y) {
                    ch.setPosition_x(x + 1);
                    ch.setPosition_y(y);
                }
            }
            for (int i = 0; i < etat.getTailleChass(); i++) {
                if (etat.getiChass(i).getPosition_x() == x && etat.getiChass(i).getPosition_y() == y) {
                    etat.getiChass(i).droite();
                }
            }
        }
    }

    /**
     * Renvoie la grille
     * @return grille
     */
    public Grille getGrille() {
        return grille;
    }


    @Override
    public void paint(Graphics g){
        super.paint(g);

        //Affichage de la grille vide
        for (int i = 0; i< grille.getTailleX(); i++){
            for (int j = 0; j< grille.getTailleY(); j++){
                creerCarre(g, i*40,j*40);
            }
        }

        //Appel des methodes d'affichage des Unites
        VueChasseur.afficheChasseur(g);
        VueCitoyen.afficheCitoyen(g);
        VueMonstre.afficheMonstre(g);

        //Affichage de l'interface avec les PV de la Base, l'argent
        g.setColor(Color.black);
        g.drawString("Argent total: " + etat.getMoney() + "฿", 0, 800);
        g.drawString("PV Base: " + etat.getBase().getPv() + "PV", 380, 800);
        //Appel de la methode d'affichage des Tours
        for(Tour t : etat.getTour()) {
            VueTour.AfficheTour(g, t.getX(), t.getY());
        }
        //Appel de la methode d'affichage de la Base (si elle n'a pas ete detruite)
        if(etat.getBase().getPv()>0) {
            VueBase.AfficheBase(g);
        }else if (etat.getBase().getPv()<=0 || etat.getTailleChass() == 0){
            //Si la Base est detruite, on ne l'affiche plus, et on affiche le message de Game Over
            g.setColor(Color.BLACK);
            g.drawRect(340, 340, 100, 30);

            g.setColor(Color.WHITE);
            g.fillRect(340, 340, 100, 30);

            g.setColor(Color.BLACK);
            g.drawString("GAME OVER", 355, 360);
        }

        /*
        int cpt = 1;
        Case[][] cases =  grille.getTabCase();
        for(Case[] ct : cases) {
            for(Case c : ct) {
                System.out.print(cpt);
                System.out.println(c.getBatiment());
                System.out.println(c.getChasseur());
                System.out.println(c.getMonstre());
                cpt++;
            }
        }
        for (Chasseur c : etat.listChasseur){
            System.out.println(c + ", " + c.getPosition_x() + ", " + c.getPosition_y());
        }
        for(Monstre m : etat.getMonstre()) {
            System.out.println("Pv du monstre" + m.getPv());
        }
        System.out.println("Thune chass" + etat.getiChass(0).getMoney());
         */
    }
}
