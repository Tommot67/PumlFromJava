package Lib;

public class Boisson {
    private String nom;
    public Substantif substantif;

    public Boisson(String nom , Genre genre){
        this.nom = nom;
        substantif = new Substantif(nom, genre);
    }
    public String getNom() {
        return nom;
    }
    public Genre getGenre() {
        return this.substantif.getGenre();
    }
}
