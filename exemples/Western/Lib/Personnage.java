package Lib;
public abstract class Personnage {
    public static Boisson BOISSON_PAR_DEFAULT = new Boisson("eau",Genre.FEMININ);
    protected String nom;
    protected String pseudo;
    private Boisson boisson;

    private Lieu lieu_actuel = null;

    public Personnage(String nom){
        this(nom, BOISSON_PAR_DEFAULT , nom);
    }
    public Personnage(String nom , Boisson boisson){
        this(nom , boisson, nom);
    }
    public Personnage(String nom , String pseudo){
        this(nom, BOISSON_PAR_DEFAULT , pseudo);
    }
    public Personnage(String nom , Boisson boisson , String pseudo){
        this.nom = nom;
        this.boisson = boisson;
        this.pseudo = pseudo;
    }
    public String getNom() {
        return this.nom;
    }
    public Boisson getBoisson() {
        return this.boisson;
    }
    public String getPseudo(){
        return this.pseudo;
    }
    public Lieu getLieu(){
        return this.lieu_actuel;
    }
    public void setLieu(Lieu lieu){
        this.lieu_actuel = lieu;
    }
    public void dire(String texte){
        System.out.println(this.nom + " - " + texte);
    }
    public void sePresenter(){
        System.out.println(this.nom + " - Bonjour, je suis " + this.pseudo + " et j'aime " + this.boisson.substantif.avecArticleDefini());
    }
    public void boire(){
        System.out.println(((Maison)lieu_actuel).peutBoire(this.boisson));
        if(lieu_actuel.equals(null) && this.boisson.getNom().contains("eau")) {
            System.out.println(this.nom + " - Ah ! boire " + this.boisson.substantif.avecArticlePartitif() + "! GLOUPS !");
            System.out.println("passe1");
        }
        else if(lieu_actuel instanceof Bar && ((Bar) lieu_actuel).peutBoire(this.boisson)){
            System.out.println(this.nom + " - Ah ! boire " + this.boisson.substantif.avecArticlePartitif() + "! GLOUPS !");
            System.out.println("passe2");
        }
        else if(lieu_actuel instanceof Maison && ((Maison)lieu_actuel).peutBoire(this.boisson)){
            System.out.println(this.nom + " - Ah ! boire " + this.boisson.substantif.avecArticlePartitif() + "! GLOUPS !");
            System.out.println("passe3");
        }
        else {
            throw new RuntimeException("Impossible de le faire boire dans ce lieu");
        }
    }
    public void boire(Boisson new_boisson) {
        System.out.println(this.nom+" - GLOUPS ! Faut vraiment avoir soif pour boire "+new_boisson.substantif.avecArticlePartitif() + " !  J’aurais préféré boire "+this.boisson.substantif.avecArticlePartitif() +" ! ");
    }
}
