package Lib;

public class Narrateur extends Personnage{
    public Narrateur(String nom) {
        super(nom , nom + ", le narrateur");
    }
    @Override
    public void sePresenter(){
        System.out.println("Bonjour, je suis " + this.pseudo );
    }
    @Override
    public void dire(String texte){
        System.out.println(texte);
    }
    @Override
    public void boire(){
        /*
        try {
            if(this.getBoisson().getNom() != "eau") {
                throw new Exception("Il est impossible de boire pour le narrateur!");
            }
            else {
                boire();
            }
        } catch (Exception e) {
            System.out.println("Il y a une erreur avec l'histoire : "+ e.getMessage());
        }
        */
        this.boire(null);
    }
    @Override
    public void boire(Boisson boisson) {
        if(!boisson.getNom().contains("eau") || (boisson.equals(null) && !this.getBoisson().getNom().contains("eau"))){
            try {
                throw new IllegalAccessException("La boisson ne peut pas être bu par le narrateur.");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        else if(boisson.equals(null)){
            super.boire();
        }
        else{
            super.boire(boisson);
        }
    }

}

