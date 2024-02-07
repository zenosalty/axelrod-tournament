package strategies.prescient;

public class Friedman extends PrescientStrategy {

    public Friedman() {
        super();
    }

    @Override
    public void prepareNextDecision(boolean opponent_cooperates) {
        if (!opponent_cooperates)
            next_decision = false;
    }
}
