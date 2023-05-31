package western;

import java.util.ArrayList;
import java.util.List;

public class Barman extends Personnage{

    private ArrayList<Personnage> listPersonnages = new ArrayList<>();
    public Barman(String nom){
        super(nom, Boisson.of("vin",Genre.MASCULIN));
    }

    @Override
    public String getPseudo(){
        return this.getNom() + " le barman de chez " + this.getNom();
    }

    @Override
    public void dire(String texte){
        super.dire(texte + " Coco");
    }

    @Override
    public void sePresenter(){
        super.sePresenter();
        this.dire("Chez " + getNom());
    }

    public void sert(Personnage personnage){
        this.dire("Et un p'tit verre de "+ personnage.getBoisson().getNom() + " pour " + personnage.getPseudo());
        personnage.boire();
        if(!this.listPersonnages.contains(personnage)){
            this.listPersonnages.add(personnage);
        }
    }

    public List<Personnage> getListPersonnages(){
        return List.copyOf(this.listPersonnages);
    }
}