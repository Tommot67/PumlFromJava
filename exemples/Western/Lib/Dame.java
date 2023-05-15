package Lib;
public class Dame extends Personnage{
    private boolean captive;
    private Cowboy uncaptive;

    private Brigand captureur;
    public Dame(String nom) {
        super(nom , "Miss " + nom);
        this.captive = false;
    }
    public Dame(String nom , Boisson boisson) {
        super(nom, boisson , "Miss " + nom);
        this.pseudo = "Miss " + nom;
        this.captive = false;
    }
    public boolean estLibre(){
        return this.captive;
    }
    public void setCaptive(boolean value){
        this.captive = value;
    }
    @Override
    public void sePresenter(){
        super.sePresenter();
        if(this.uncaptive != null && this.captureur != null) {
            if (this.captive) {
                System.out.println(this.nom + " – Je suis captive de cet escroc de " + this.captureur);
            } else {
                System.out.println(this.nom + " - Je suis libre grâce à mon sauveur " + this.uncaptive);
            }
        }
    }
    public void sos(Brigand brigand){
        System.out.println("Hiiii ! Au secours ! " + brigand.pseudo + " m’enlève !");
    }
    public void remerciement(Cowboy cowboy){
        System.out.println("Merci "+ cowboy.nom +", tu es mon sauveur !");
    }
}
