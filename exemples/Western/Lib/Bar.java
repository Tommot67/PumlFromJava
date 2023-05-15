package Lib;

import java.util.ArrayList;
import java.util.List;

public class Bar extends Lieu{

    public static ArrayList<Boisson> boissons_default = new ArrayList<>(List.of(new Boisson("eau",Genre.FEMININ), new Boisson("biére",Genre.FEMININ)));
    private ArrayList<Boisson> boissons_possible = new ArrayList<>();
    public Bar(String nom, Personnage dirigant){
        super(nom, dirigant);
    }
    public Bar(String nom, Personnage dirigant, Location location){
        super(nom, dirigant, location);
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
        return boissons_default.contains(boisson) ? true : this.boissons_possible.contains(boisson) ? true : false;
    }
    public void entreBar(Personnage personnage){
        personnage.setLieu(this);
    }
    public void sortirBar(Personnage personnage){
        personnage.setLieu(null);
    }
}
