package Lib;

import java.util.ArrayList;

public class Brigand extends Personnage implements Hors_La_Loi {

    public static int capture_récompense = 50;
    public static int récompense_default = 100;
    private int récompense;
    private boolean capturer = false;
    private Cowboy cowboy_capture;
    private ArrayList<Dame> capture = new ArrayList<>();
    public Brigand(String nom) {
        this(nom, "le méchant");
    }
    public Brigand(String nom , String look) {
        super(nom , nom + " " + look);
        this.récompense = récompense_default;
    }
    public Brigand(String nom, Boisson boisson) {
        this(nom , boisson , "le méchant");
    }
    public Brigand(String nom , Boisson boisson , String look) {
        super(nom, boisson , nom + " " + look);
        this.récompense = récompense_default;
    }

    public int getRécompense() {
        return this.récompense;
    }
    public void setRécompense(int value){
        this.récompense = value;
    }
    public ArrayList<Dame> getCapture(){
        return this.capture;
    }

    public void seFaireTirerDessus(Cowboy cowBoy)
    {
        dire(String.format("Tu n'es qu'un coyote, %s !", cowBoy.getPseudo()));
    }

    public boolean estLibre() {
        return this.capturer;
    }

    @Override
    public void sePresenter(){
        super.sePresenter();
        System.out.println(this.nom + " - Ma tête est mise à prix "+this.récompense+" $ !");
        if(!this.capturer){
            System.out.println(this.nom +" - Je suis libre");
        }
        else {
            System.out.println(this.nom +" - Je suis le prisonnier de " + this.cowboy_capture.getPseudo());
        }
    }
    public void kidnapper(Dame dame) {
        dame.setCaptive(true);
        this.récompense+=capture_récompense;
        this.capture.add(dame);
        System.out.println(this.nom +" - Ah, ah ! "+ dame.getPseudo() +", tu es mienne désormais !");
    }
    public void seFaireCapturer(Cowboy cowboy){
        cowboy_capture = cowboy;
        this.capturer = true;
        this.capture.clear();
        System.out.println(this.nom+" - Damned, je suis fait ! Tu m'as eu, "+cowboy.nom +" !  Mais tu n'emporteras pas les "+this.récompense+" $ au paradis.");
    }
}
