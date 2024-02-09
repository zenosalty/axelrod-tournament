package strategies.blind;

import strategies.Outcome;
import strategies.Strategy;

public class AlwaysDefect implements Strategy {
    @Override
    public Outcome decide() {
        return Outcome.DEFECT;
    }

    public String toString() {
        return "Always Defect";
    }
}
