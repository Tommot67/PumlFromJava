package Lib;

import java.util.ArrayList;

public class Prison extends Lieu{
    public static ArrayList<Sherif> total_dirigants = new ArrayList<>();
    private ArrayList<Brigand> prisonnier = new ArrayList<>();
    private ArrayList<Sherif> dirigants = new ArrayList<>();
    public Prison(String nom , ArrayList<Sherif> dirigants) {
        super(nom, dirigants.get(0));
        this.dirigants = dirigants;
        this.addRangeInit(dirigants);
    }

    public Prison(String nom, ArrayList<Sherif> dirigants, Location location) {
        super(nom, dirigants.get(0), location);
        this.dirigants = dirigants;
        this.addRangeInit(dirigants);
    }
    private void addRangeInit(ArrayList<Sherif> dirigants){
        for (Sherif sherif:dirigants) {
            if(!total_dirigants.contains(sherif)){
                total_dirigants.add(sherif);
            }
        }
    }
    public void setNewPrisonnier(Brigand brigand){
        if(!this.isPrisonnier(brigand)) {
            this.prisonnier.add(brigand);
            brigand.setLieu(this);
        }
        else{
            throw new IllegalArgumentException("Déjà en prison");
        }
    }
    public void echaper(Brigand brigand){
        this.prisonnier.remove(brigand);
    }
    public boolean isPrisonnier(Personnage personnage){
        return this.prisonnier.contains(personnage);
    }
    public boolean isDirigant(Sherif sherif){
        return this.dirigants.contains(sherif);
    }
}
