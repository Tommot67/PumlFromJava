import Lib.*;

import java.util.ArrayList;
import java.util.List;

public class HistoireBis {
    public static void main(String[] args) {
        Cowboy luke = new Cowboy("luke");
        Dame jolie = new Dame("jolie");
        Brigand mechant =  new Brigand("jack","le gentil");
        luke.sePresenter();
        jolie.sePresenter();
        mechant.sePresenter();
        Sherif sherif1 = new Sherif("luke2");
        Prison prison = new Prison("Babbabbagne", new ArrayList<>(List.of(sherif1)));
        Maison jolie_maison = new Maison("jolie maison",jolie);
        jolie_maison.entreMaison(jolie);
        jolie_maison.invitePersonnage(luke);
        System.out.println(luke.getLieu());
        luke.boire();
    }
}
