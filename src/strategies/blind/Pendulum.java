package strategies.blind;

import strategies.Outcome;
import strategies.Strategy;

public class Pendulum implements Strategy {

    private final int period;
    private int pendulum;
    private boolean nice;

    public Pendulum(int p, boolean n) {
        period = p;
        nice = n;
        pendulum = 0;
    }

    @Override
    public Outcome decide() {

        if (pendulum == period) {
            nice = !nice;
            pendulum = 0;
        }

        pendulum++;

        return nice ? Outcome.COOPERATE : Outcome.DEFECT;
    }
}
