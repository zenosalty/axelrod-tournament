package strategies.prescient;

import strategies.Outcome;

public class Tester extends PrescientStrategy {

    private boolean testing;
    private boolean tft;

    public Tester() {
        next_decision = Outcome.DEFECT; //Tester is not welcoming
        testing = false; //first move -> no testing
        tft = false;
    }

    private void test(Outcome o) {
        if (Outcome.COOPERATE == o) {
            next_decision = testing ? Outcome.DEFECT : Outcome.COOPERATE;
            testing = !testing;
        } else {
            next_decision = Outcome.COOPERATE; //apologize...
            tft = true; //...and then play tft
        }
    }

    @Override
    public void prepareNextDecision(Outcome o) {
        if (tft)
            next_decision = o;
        else
            test(o);
    }

    public String toString() {
        return "Tst";
    }
}
