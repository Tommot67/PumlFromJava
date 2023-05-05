package Lib;

import java.lang.annotation.Inherited;
import java.util.ArrayList;

public class Sherif extends Cowboy{
    public Sherif(String nom , Boisson boisson){
        super(nom,boisson);
    }
    public Sherif(String nom ){
        super(nom);
    }
    public void envoiePrison(Prison prison, Brigand brigand , boolean overbook) {

        if (this.capture.contains(brigand) && prison.isDirigant(this) && !overbook) {
            prison.setNewPrisonnier(brigand);
        }
        else if((!Prison.total_dirigants.contains(this) && this.capture.contains(brigand)) || (overbook && this.capture.contains(brigand))) {
            prison.setNewPrisonnier(brigand);
        }
        else if(!this.capture.contains(brigand)){
            throw new IllegalArgumentException("Prisonnier non capturé !!!");
        }
        else {
            throw new IllegalArgumentException("Choix de la mauvaise prison, 'Un prisonnier doit aller dans la prison du Sherif' !!!");
        }
    }
}
