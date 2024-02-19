/*
 * Friedman makes things clear to its opponent:
 * Friedman will start cooperating, and it will
 * continue to do so as long as the opponent
 * does not retaliate. Otherwise, Friedman takes
 * its revenge by defecting till the end.
 */

package strategies.prescient;

import strategies.Outcome;

public class Friedman extends PrescientStrategy {

    public Friedman() {
        super();
    }

    @Override
    public void prepareNextDecision(Outcome o) {
        if (Outcome.DEFECT == o)
            next_decision = Outcome.DEFECT;
    }

    public String toString() {
        return "Friedman";
    }
}