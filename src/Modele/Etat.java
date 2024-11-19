package src.Modele;

import src.Affiche.Affiche;

import java.util.ArrayList;

/**
 * Classe permettant de gérer chaque unité et les tours dans des listes
 */
public class Etat{

    /*Attributs*/
    public ArrayList<Chasseur> listChasseur;
    private ArrayList<Citoyen> listCitoyen;
    private ArrayList<Monstre> listMonstre;
    private ArrayList<Tour> listTour;
    private Base base;
    private  int argentChasseurs = 0;

    public Etat(){
        this.listChasseur = new ArrayList<>();
        this.listCitoyen = new ArrayList<>();
        this.listMonstre = new ArrayList<>();
        this.listTour = new ArrayList<>();
        this.base = new Base(Affiche.Xcase/2, Affiche.Ycase/2);
        this.argentChasseurs = 0;
    }

    /*Methodes*/

    /**
     * Ajoute un chasseur en argument à la liste
     * @param c, le chasseur qui va être ajouté à la liste
     */
    public void addChasseur(Chasseur c){
        this.listChasseur.add(c);
    }

    /**
     * Ajoute un citoyen en argument à la liste
     * @param c, le citoyen qui va être ajouté à la liste
     */
    public void addCitoyen(Citoyen c){
        this.listCitoyen.add(c);
    }

    /**
     * Ajoute un monstre en argument à la liste
     * @param m, le monstre qui va être ajouté à la liste
     */
    public void addMonstre(Monstre m){
        this.listMonstre.add(m);
    }

    /**
     * Ajoute une tour en argument à la liste
     * @param t, la tour qui va être ajouté à la liste
     */
    public void addTour(Tour t){
        this.listTour.add(t);
    }

    /**
     * Ajoute l'argent en argument à son propre compteur
     * @param m, la somme d'argent à ajouter
     */
    public void addMoney(int m){
        argentChasseurs += m;
    }

    /**
     * Ajoute l'argent en argument à son propre compteur
     * @param m, la somme d'argent à retirer
     */
    public void removeMoney(int m){
        argentChasseurs -= m;
    }

    /**
     * Renvoie la liste des chasseurs
     * @return listChasseur
     */
    public ArrayList<Chasseur> getChasseurs(){
        return this.listChasseur;
    }

    /**
     * Renvoie la liste des citoyens
     * @return listCitoyens
     */
    public ArrayList<Citoyen> getCitoyens(){
        return this.listCitoyen;
    }

    /**
     * Renvoie la liste des monstres
     * @return listMonstre
     */
    public ArrayList<Monstre> getMonstre(){
        return this.listMonstre;
    }

    /**
     * Renvoie la liste des tours
     * @return listTour
     */
    public ArrayList<Tour> getTour(){
        return this.listTour;
    }

    /**
     * Renvoie l'argent total des chasseurs
     * @return argentsChasseurs
     */
    public int getMoney() {
        return this.argentChasseurs;
    }

    /**
     * Renvoie la taille de la liste des chasseurs
     * @return size() la taille de la liste
     */
    public int getTailleChass(){
        return this.listChasseur.size();
    }

    /**
     * Renvoie la taille de la liste des citoyens
     * @return size() la taille de la liste
     */
    public int getTailleCit(){
        return this.listCitoyen.size();
    }

    /**
     * Renvoie la taille de la liste des monstres
     * @return size() la taille de la liste
     */
    public int getTailleMst(){
        return this.listMonstre.size();
    }


    /**
     * Renvoie le chasseur à l'indice i
     * @param i
     * @return chasseur à l'indice i
     */
    public Chasseur getiChass(int i){
        return this.listChasseur.get(i);
    }

    /**
     * Renvoie le citoyen à l'indice i
     * @param i
     * @return citoyen à l'indice i
     */
    public Citoyen getiCit(int i){
        return this.listCitoyen.get(i);
    }

    /**
     * Renvoie le monstre à l'indice i
     * @param i
     * @return monstre à l'indice i
     */
    public Monstre getiMst(int i){
        return this.listMonstre.get(i);
    }

    /**
     * Renvoie la tour à l'indice i
     * @param i l'indice
     * @return tour à l'indice i
     */
    public Tour getiTour(int i){
        return this.listTour.get(i);
    }

    public Base getBase() {
        return this.base;
    }
}
