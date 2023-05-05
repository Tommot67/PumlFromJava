package Lib;

import java.util.ArrayList;
import java.util.List;

public class Maison extends Lieu{
    public static ArrayList<Boisson> boissons_default = new ArrayList<>(List.of(new Boisson("eau",Genre.FEMININ)));
    private ArrayList<Boisson> boissons_possible = new ArrayList<>();
    public Maison(String nom, Personnage appartient){
        super(nom, appartient);
    }
    public Maison(String nom, Personnage appartient, Location location){
        super(nom, appartient, location);
    }
    public boolean setNewBoisson(Boisson boisson){
        if(peutBoire(boisson)){
            return false;
        }
        else{
            this.boissons_possible.add(boisson);
            return true;
        }
    }
    public void removeBoisson(Boisson boisson){
        if(this.boissons_possible.contains(boisson)){
            this.boissons_possible.remove(boisson);
        }
    }
    public boolean peutBoire(Boisson boisson){
        for (Boisson boisson2:boissons_default) {
            if(boisson2.getNom().contains(boisson.getNom())){
                return true;
            }
        }
        for (Boisson boisson2:boissons_possible) {
            if(boisson2.getNom().contains(boisson.getNom())){
                return true;
            }
        }
        return false;
    }

    public boolean entreMaison(Personnage personnage){
        if(personnage.equals(this.getAppartient())){
            personnage.setLieu(this);
            return true;
        }
        else{
            return false;
        }
    }
    public void invitePersonnage(Personnage personnage){
        personnage.setLieu(this);
    }
    public void sortirMaison(Personnage personnage){
        personnage.setLieu(null);
    }
}
