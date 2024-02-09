package strategies.prescient;

import strategies.Outcome;

public class NonForgivingSample extends Sample {

    public Outcome decide() {
        //This version is non-forgiving:
        //if the opponent perseveres
        return previous_defections < 2 ? Outcome.COOPERATE : Outcome.DEFECT;
    }

    public String toString() {
        return "NonForgivingSample";
    }
}
