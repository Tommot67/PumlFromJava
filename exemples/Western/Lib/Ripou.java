package Lib;

import java.util.ArrayList;

public class Ripou extends Cowboy implements Hors_La_Loi
{
    private Brigand brigand;

    public Ripou(String nom)
    {
        super(nom, BOISSON_PAR_DEFAULT);
        this.brigand = new Brigand(super.getNom());
    }

    public Ripou(String nom, Boisson boisson)
    {
        super(nom, boisson);
        this.brigand = new Brigand(super.getNom(), boisson);
    }

    public Ripou(String nom, Boisson boisson, String look)
    {
        super(nom, boisson);
        this.brigand = new Brigand(super.getNom(), boisson, look);
    }

    @Override
    public String getPseudo()
    {
        return this.brigand.getPseudo();
    }

    @Override
    public boolean estLibre()
    {
        return this.brigand.estLibre();
    }

    @Override
    public int getRécompense()
    {
        return this.brigand.getRécompense();
    }

    @Override
    public void kidnapper(Dame dame)
    {
        this.brigand.kidnapper(dame);
    }

    @Override
    public ArrayList<Dame> getCapture()
    {
        return this.brigand.getCapture();
    }

    @Override
    public void seFaireCapturer(Cowboy cowBoy)
    {
        this.brigand.seFaireCapturer(cowBoy);
    }

    @Override
    public void seFaireTirerDessus(Cowboy cowBoy)
    {
        this.brigand.seFaireTirerDessus(cowBoy);
    }

    @Override
    public void sePresenter()
    {
        if (this.estLibre())
            super.sePresenter();
        else
            this.brigand.sePresenter();
    }

    @Override
    public void delivre(Dame dame)
    {
        if (dame.estLibre())
            throw new IllegalStateException("La dame est déjà libre");
        this.kidnapper(dame);
    }

}
