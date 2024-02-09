package strategies.blind;

import strategies.Strategy;
import strategies.Outcome;

public class AlwaysCooperate implements Strategy {
    @Override
    public Outcome decide() {
        return Outcome.COOPERATE;
    }

    public String toString() {
        return "Always Cooperate";
    }
}