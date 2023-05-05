package Lib;

import java.util.ArrayList;

public interface Hors_La_Loi {
    boolean estLibre();
    int getRécompense();
    void kidnapper(Dame dame);
    void seFaireCapturer(Cowboy cowBoy);
    void seFaireTirerDessus(Cowboy cowBoy);
    String getPseudo();
    ArrayList<Dame> getCapture();

}
