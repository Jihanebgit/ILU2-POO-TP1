package villagegaulois;

//TODO bonnes pratique exception personnalisée
public class VillageSansChefException extends Exception {

    public VillageSansChefException() {
        super("Le village n'a pas de chef !");
    }
}