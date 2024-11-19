package src.Controle;
import src.Modele.*;
import src.Affiche.*;

/**
 * Classe qui permet gerer les déplacements automatiques des monstres,
 * leur mort,
 * l'interaction avec les chasseurs, les citoyens et les batiments (les attaques)
 */
public class MoveMonstre extends Thread{
    private Etat etat;
    private Affiche affiche;
    private Grille grille;

    public MoveMonstre(Affiche a, Etat e, Grille g){
        this.etat = e;
        this.affiche = a;
        this.grille = g;
    }

    //Methode Run du Thread MoveMonstre:
    @Override
    public void run(){
        while(etat.getBase().getPv()>0){
            try{
                //Toutes les 7 secondes
                Thread.sleep(7000);
                //Pour chaque Monstre present dans l'Etat
                for(int i=0; i < etat.getTailleMst(); i++){
                    int x = etat.getiMst(i).getPosition_x();
                    int y = etat.getiMst(i).getPosition_y();
                    //Les Monstres morts sont supprimes
                    if (etat.getiMst(i).getPv() <= 0){
                        etat.getMonstre().remove(i);
                        grille.getCase(x, y).setMonstre(null);
                    }else{
                        //Et pour chaque Monstre vivant:
                        //Le deplacement s'effectue dans la Grille et l'Etat
                        etat.getiMst(i).MovementMst();
                        int nouvx = etat.getiMst(i).getPosition_x();
                        int nouvy = etat.getiMst(i).getPosition_y();
                        grille.getCase(nouvx, nouvy).setMonstre(grille.getCase(x, y).getMonstre());
                        grille.getCase(x, y).setMonstre(null);
                        //Ensuite, pour chaque Tour presente dans l'Etat
                        for(Tour t : etat.getTour()) {
                            //Si le Monstre se trouve sur la case de la Tour ou une des cases adjacentes, il prend des degats
                            if((t.getX()/40 == nouvx && t.getY()/40 == nouvy)
                                    || (t.getX()/40 == nouvx && (t.getY()/40)+1 == nouvy)
                                    || (t.getX()/40 == nouvx && (t.getY()/40)-1 == nouvy)
                                    || ((t.getX()/40)+1 == nouvx && t.getY()/40 == nouvy)
                                    || ((t.getX()/40)-1 == nouvx && t.getY()/40 == nouvy)) {
                                grille.getCase(x, y).attaqueTourMst();
                                etat.getiMst(i).pertePV(Tour.PA);
                            }
                            //Si il se trouve sur la Tour, il l'attaque
                            if(t.getX()/40 == nouvx && t.getY()/40 == nouvy) {
                                grille.getCase(x, y).attaqueMstBatiment();
                                t.pertePV(etat.getiMst(i).getpa());
                            }
                            //Si la Tour n'a plus de PV, elle est supprimee
                            if(t.getPv() <= 0) {
                                etat.getTour().remove(t);
                                grille.getCase(x, y).setBatiment(null);
                            }
                        }
                        //Puis, pour chaque Chasseur dans l'Etat
                        for(int j = 0; j < etat.getTailleChass(); j++) {
                            Chasseur c = etat.getiChass(j);
                            //si le Monstre est sur la position du Chasseur, il l'attaque
                            if(c.getPosition_x() == nouvx && c.getPosition_y() == nouvy) {
                                grille.getCase(x, y).attaqueMstChass();
                                c.pertePV(etat.getiMst(j).getpa());
                            }
                            //Si il est sur une des cases adjacentes du Chasseur ou sur le chasseur, il se fait attaquer
                            if((c.getPosition_x() == nouvx && c.getPosition_y() == nouvy)
                                    || (c.getPosition_x() == nouvx && c.getPosition_y()+1 == nouvy)//Adjacent haut 1
                                    || (c.getPosition_x() == nouvx && c.getPosition_y()-1 == nouvy)//Adjacent bas 1
                                    || (c.getPosition_x()+1 == nouvx && c.getPosition_y() == nouvy)//Adjacent droite 1
                                    || (c.getPosition_x()-1 == nouvx && c.getPosition_y() == nouvy)//Adjacent gauche 1

                                    || (c.getPosition_x()+1 == nouvx && c.getPosition_y()+1 == nouvy)//Diago haut droit
                                    || (c.getPosition_x()-1 == nouvx && c.getPosition_y()-1 == nouvy)//Diago bas gauche
                                    || (c.getPosition_x()-1 == nouvx && c.getPosition_y()+1 == nouvy)//Diago haut gauche
                                    || (c.getPosition_x()+1 == nouvx && c.getPosition_y()-1 == nouvy)//Diago bas droite
                            ) {
                                grille.getCase(x, y).attaqueChassMst();
                                etat.getiMst(j).pertePV(c.getpa());
                            }
                            //Si le Chasseur n'a plus de PV, il est supprime
                            if(c.getPv() <= 0) {
                                etat.getChasseurs().remove(j);
                                grille.getCase(x, y).setChasseur(null);
                            }
                        }
                        //Enfin, si le Monstre se trouve sur la Base, il l'attaque
                        if(x==etat.getBase().getX() && y==etat.getBase().getY() && etat.getBase().getPv()>0) {
                            grille.getCase(x, y).attaqueMstBatiment();
                            etat.getBase().pertePV(etat.getiMst(i).getpa());
                            if(etat.getBase().getPv()<=0) {
                                grille.getCase(x, y).setBatiment(null);
                            }
                        }


                    }
                }
                this.affiche.repaint();
                this.affiche.revalidate();
            } catch (Exception e) { e.printStackTrace(); }
        }
    }
}
