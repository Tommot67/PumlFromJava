package western;

public class Histoire5
{
    public static void main(String[] args) {
        Barman barman_lolo = new Barman("Lolo");
        Ripou ripou_bob = new Ripou("Bob" , Boisson.of("biére", Genre.FEMININ));
        Sherif sherif_luke = new Sherif("Luke");

        barman_lolo.sePresenter();
        ripou_bob.sePresenter();
        sherif_luke.sePresenter();

        barman_lolo.sert(ripou_bob);
        barman_lolo.sert(sherif_luke);
        barman_lolo.sert(barman_lolo);
        sherif_luke.capturer(ripou_bob);

        barman_lolo.sePresenter();
        ripou_bob.sePresenter();
        sherif_luke.sePresenter();

    }
}