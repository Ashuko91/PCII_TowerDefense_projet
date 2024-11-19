package src.Controle;
import src.Modele.*;
import src.Affiche.*;

/**
 * Classe qui permet gerer les déplacements automatiques des citoyens,
 * leur mort,
 * l'interaction avec les chasseurs (argent)
 */
public class MoveCitoyen extends Thread{
    private Etat etat;
    private Affiche affiche;
    private Grille grille;

    public MoveCitoyen(Affiche a, Etat e, Grille g){
        this.etat = e;
        this.affiche = a;
        this.grille = g;
    }

    //Methode Run du Thread MoveCitoyen:
    @Override
    public void run(){
        while(etat.getBase().getPv()>0){
            try{
                //Toutes les 3 secondes
                Thread.sleep(5000);
                //Pour chaque Citoyen present dans l'Etat
                for(int i=0; i < etat.getTailleCit(); i++){
                    int x = etat.getiCit(i).getPosition_x();
                    int y = etat.getiCit(i).getPosition_y();
                    //Pour chaque Chasseur de l'Etat, si il se trouve sur la meme case que le Citoyen, il recupere son argent
                    for(Chasseur c : etat.getChasseurs()) {
                        if(c.getPosition_x() == x && c.getPosition_y() == y) {
                            etat.addMoney(etat.getiCit(i).getMoney());
                            etat.getiCit(i).removeMoney();
                        }
                    }
                    //Si le Citoyen n'a plus de PV, il est supprime
                    if (etat.getiCit(i).getPv() <= 0){
                        etat.getCitoyens().remove(i);
                        grille.getCase(x, y).setCitoyen(null);
                    }else{
                        //Sinon, pour chaque Citoyen vivant
                        etat.getiCit(i).addMoney();
                        etat.getiCit(i).MovementAleat();
                        int nouvx = etat.getiCit(i).getPosition_x();
                        int nouvy = etat.getiCit(i).getPosition_y();
                        //Pour chaque Monstre de l'Etat
                        for(Monstre m : etat.getMonstre()) {
                            //Si il se trouve sur la meme case que le Citoyen, alors il l'attaque
                            if((nouvx) == m.getPosition_x() && (nouvy == m.getPosition_y())) {
                                grille.getCase(x,y).attaqueMstCit();
                                etat.getiCit(i).pertePV(m.getpa());
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

