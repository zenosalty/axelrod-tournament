package strategies.prescient;

public class NonForgivingSample extends Sample {

    public boolean decide() {
        //This version is non-forgiving:
        //if the opponent perseveres
        return previous_defections < 2;
    }
}
