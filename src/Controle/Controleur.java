package src.Controle;

import src.Modele.*;
import src.Affiche.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Classe qui permet de gérer les boutons
 * en fonction de l'action de l'utilisateur
 */
public class Controleur extends JPanel implements MouseListener {

    private Affiche aff;
    private Etat etat;

    public int selectedX; // Variable qui va stocker l'abscisse du clic
    public int selectedY; // Variable qui va stocker l'ordonnée du clic
    public static final int prixTour = 50;
    public static final int prixChasseur = 80;
    public static final int prixCitoyen = 100;

    public Controleur(Affiche a, Etat e) {
        this.aff = a;
        this.setLayout(new GridLayout(0, 4));
        this.etat = e;

        //boutton directionnel haut pour le chasseur
        JButton up = new JButton("↑");
        up.setPreferredSize(new Dimension(130, 55));
        this.add(up);
        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Desactivation du bouton si la partie est perdue
                if (etat.getBase().getPv() > 0) {
                    aff.hautChasseur(selectedX, selectedY);
                    aff.repaint();
                    aff.revalidate();
                }
            }
        });

        //boutton directionnel bas pour le chasseur
        JButton down = new JButton("↓");
        down.setPreferredSize(new Dimension(130, 55));
        this.add(down);
        down.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Desactivation du bouton si la partie est perdue
                if (etat.getBase().getPv() > 0) {
                    aff.basChasseur(selectedX, selectedY);
                    aff.repaint();
                    aff.revalidate();
                }
            }
        });

        //boutton directionnel gauche pour le chasseur
        JButton gauche = new JButton("←");
        gauche.setPreferredSize(new Dimension(50, 40));
        this.add(gauche);
        gauche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Desactivation du bouton si la partie est perdue
                if (etat.getBase().getPv() > 0) {
                    aff.gaucheChasseur(selectedX, selectedY);
                    aff.repaint();
                    aff.revalidate();
                }
            }
        });

        //boutton directionnel droit pour le chasseur
        JButton droite = new JButton("→");
        droite.setPreferredSize(new Dimension(50, 40));
        this.add(droite);
        droite.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Desactivation du bouton si la partie est perdue
                if (etat.getBase().getPv() > 0) {
                    aff.droiteChasseur(selectedX, selectedY);
                    aff.repaint();
                    aff.revalidate();
                }
            }
        });

        //definition du bouton de creation de tour
        JButton batiment = new JButton("Tour :" + prixTour + "฿");
        batiment.setPreferredSize(new Dimension(150, 55));
        this.add(batiment);
        batiment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Si l'économie est suffisante et si la partie n'est pas perdue
                if (etat.getMoney() - prixTour >= 0 && etat.getBase().getPv() > 0) {
                    aff.ajoutTour(selectedX, selectedY);
                    //On retire le prix de la tour à l'economie
                    etat.removeMoney(prixTour);
                    aff.repaint();
                    aff.revalidate();
                }
            }

        });

        //definition du bouton de creation de chasseurs
        JButton chasseur = new JButton("Chasseur : " + prixChasseur + "฿");
        chasseur.setPreferredSize(new Dimension(130, 55));
        this.add(chasseur);
        chasseur.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Si l'économie est suffisante et si la partie n'est pas perdue
                if (etat.getMoney() - prixChasseur >= 0 && etat.getBase().getPv() > 0) {
                    aff.creerChasseur(selectedX, selectedY);
                    //On retire le prix du chasseur à l'economie
                    etat.removeMoney(prixChasseur);
                    aff.repaint();
                    aff.revalidate();
                }
            }
        });

        //definition du bouton de creation de citoyens
        JButton citoyen = new JButton("Citoyen : " + prixCitoyen + "฿");
        citoyen.setPreferredSize(new Dimension(130, 55));
        this.add(citoyen);
        citoyen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Si l'économie est suffisante et si la partie n'est pas perdue
                if (etat.getMoney() - prixCitoyen >= 0 && etat.getBase().getPv() > 0) {
                    aff.creerCitoyen(selectedX, selectedY);
                    //On retire le prix du citoyen à l'economie
                    etat.removeMoney(prixCitoyen);
                    aff.repaint();
                    aff.revalidate();
                }
            }
        });

        //bouton test pour les monstres
        /*
        JButton monstre = new JButton("Creer Monstre");
        monstre.setPreferredSize(new Dimension(130, 55));
        this.add(monstre);
        monstre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aff.creerMonstre(selectedX, selectedY);
            }
        });
        */

    }


    /**
     * Stock l'ordonnée et l'abscisse d'un clic
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        selectedX = e.getX();
        selectedY = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
}