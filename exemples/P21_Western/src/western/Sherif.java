package western;

import java.util.ArrayList;
import java.util.List;

public class Sherif extends Cowboy{

    private ArrayList<HorsLaLoi> wanted = new ArrayList<>();
    public Sherif(String nom){
        super(nom);
    }

    public Sherif(String nom , Boisson boisson){
        super(nom,boisson);
    }

    @Override
    public String getNom(){
        return "Shérif " + super.getNom();
    }

    @Override
    public void sePresenter(){
        super.sePresenter();
        if(wanted.isEmpty()) {
            this.dire("Je recherche "+ getPseudos(List.copyOf(this.wanted)));
        }
    }

    @Override
    public void capturer(HorsLaLoi horsLaLoi){
        this.dire("Au nom de la loi, " + horsLaLoi.getPseudo()  + ", je t’arrête !");
        super.capturer(horsLaLoi);
        if(this.wanted.contains(horsLaLoi)){
            this.wanted.remove(horsLaLoi);
        }
    }

    public List<HorsLaLoi> getWanted() {
        return List.copyOf(this.wanted);
    }

    public boolean isWanted(HorsLaLoi horsLaLoi){
        return this.wanted.contains(horsLaLoi);
    }

    public void rechercher(HorsLaLoi horsLaLoi){
        this.wanted.add(horsLaLoi);
    }
}