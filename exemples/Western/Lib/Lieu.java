package Lib;

public abstract class Lieu {
    private String nom;
    private Personnage appartient;
    private Location location;
    public Lieu(String nom , Personnage appartient){
        this.nom = nom;
        this.appartient = appartient;
    }
    public Lieu(String nom , Personnage appartient, Location location){
        this.nom = nom;
        this.appartient = appartient;
        this.location = location;
    }
    public String getNom() {
        return nom;
    }
    public Location getLocation() {
        return location;
    }
    public Personnage getAppartient(){
        return this.appartient;
    }
    @Override
    public String toString(){
        return this.nom;
    }
}
