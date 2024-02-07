package strategies.prescient;

public class TitForTat extends PrescientStrategy {

    public TitForTat() {
        super();
    }

    public void prepareNextDecision(boolean opponent_cooperates) {
        next_decision = opponent_cooperates;
    }
}
