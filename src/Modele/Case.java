package src.Modele;

public class Case{
    private Batiment batiment; //Objet Batiment de la case
    private Chasseur chasseur; //Objet Chasseur sur la case
    private Citoyen citoyen; //Objet Citoyen sur la case
    private Monstre monstre; //Objet Monstre sur la case
    private int positionx, positiony; //coordonnée x et y de la case dans la grille

    /*
    | Constructeur
    | @param positionX, positionY : coordonnées de la case dans la grille
     */
    public Case(int x, int y) {
        this.batiment = null;
        this.chasseur = null;
        this.citoyen = null;
        this.monstre = null;
        this.positionx = x;
        this.positiony = y;
    }

    /* getters et setters */
    public Batiment getBatiment() {
        return this.batiment;
    }

    public Chasseur getChasseur() {
        return this.chasseur;
    }

    public Citoyen getCitoyen() {
        return this.citoyen;
    }

    public Monstre getMonstre() {
        return this.monstre;
    }

    public void setBatiment(Batiment b) {
        this.batiment = b;
    }

    public void setChasseur(Chasseur c) {
        this.chasseur = c;
    }

    public void setCitoyen(Citoyen c) {
        this.citoyen = c;
    }

    public void setMonstre(Monstre m) {
        this.monstre = m;
    }

    /**
     * Lorsqu'un monstre et un citoyen sont dans la meme case
     * le monstre fait perdre des pv au citoyen
     */
    public void attaqueMstCit(){
        if (!(this.getMonstre() == null) && !(this.getCitoyen() == null)){
            this.getCitoyen().pertePV(this.getMonstre().getpa());
        }
    }

    /**
     * Lorsqu'un monstre et un chasseur sont dans la meme case
     * le monstre fait perdre des pv au chasseur
     */
    public void attaqueMstChass(){
        if (!(this.getMonstre() == null) && !(this.getChasseur() == null)){
            this.getMonstre().pertePV(this.getChasseur().getpa());
        }
    }

    /**
     * Lorsqu'un monstre et un chasseur sont dans la meme case
     * le chasseur fait perdre des pv au monstre
     */
    public void attaqueChassMst(){
        if (!(this.getMonstre() == null) && !(this.getChasseur() == null)){
            this.getMonstre().pertePV(this.getChasseur().getpa());
        }
    }

    /**
     * Lorsqu'un monstre et un batiment sont dans la meme case
     * le monstre fait perdre des pv au batiment
     */
    public void attaqueMstBatiment() {
        if (!(this.getBatiment() == null) && !(this.getMonstre() == null)) {
            this.getBatiment().pertePV(this.getMonstre().getpa());
        }
    }

    /**
     * Lorsqu'une tour et un montre sont dans la meme case
     * la tour fait perdre des pv au monstre
     */
    public void attaqueTourMst() {
        if (!(this.getBatiment() == null) && (this.getBatiment() instanceof Tour) && !(this.getMonstre() == null)) {
            this.getMonstre().pertePV(Tour.PA);
        }
    }
}
