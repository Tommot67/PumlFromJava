package Lib;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Cowboy extends Personnage implements Hors_La_Loi{
    ArrayList<Hors_La_Loi> capture = new ArrayList<>();
    private int récompense;
    public Cowboy(String nom) {
        super(nom);
    }

    public int getRécompense() {
        return récompense;
    }

    public void setRécompense(int récompense) {
        this.récompense = récompense;
    }

    public Cowboy(String nom, Boisson boisson) {
        super(nom, boisson);
    }
    @Override
    public void sePresenter(){
        super.sePresenter();
        if(!this.capture.isEmpty()){
            String temp = "";
            for (var value:this.capture) {
                temp += value.getPseudo() + ", ";
            }
            System.out.println(this.nom + " – J’ai déjà empoché "+ this.récompense +"$ en capturant " + temp);
        }
    }
    public void tirerSur(Hors_La_Loi brigand) {
        System.out.println(this.nom +" - PAN ! PAN ! Prends ça, chacal de "+ brigand.getPseudo() +" !");
        brigand.seFaireTirerDessus(this);
    }
    public void capturer(Hors_La_Loi brigand) {
        this.capture.add(brigand);
        this.récompense += brigand.getRécompense();
        brigand.seFaireCapturer(this);
        //brigand.setRécompense(Brigand.récompense_default);
        for (Dame dame: brigand.getCapture()) {
            this.delivre(dame);
        }
    }
    public void delivre(Dame dame){
        dame.setCaptive(false);
        System.out.println(this.nom+" - Voilà "+ dame.getPseudo() +", tu es libre maintenant !");
    }
}
