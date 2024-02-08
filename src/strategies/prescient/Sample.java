/*
 * Sample was provided by Axelrod
 * as an example of strategy.
 *
 * Sample starts every match by
 * cooperating. It only defects
 * when its opponent had defected
 * twice in a row.
 *
 * Here's an example of a match
 * between Sample (S) and an
 * unknown opponent (o):
 *
 * Round: 1 2 3 4 5 6 7
 *     S: C C C C D C C
 *     O: D C D D C C C
 */

package strategies.prescient;

import strategies.Outcome;
import strategies.Strategy;

public class Sample extends PrescientStrategy {

    protected int previous_defections;

    public Sample() {
        super();
        previous_defections = 0;
    }

    public void prepareNextDecision(Outcome o) {
        if (Outcome.COOPERATE == o)
            previous_defections = 0;
        else
            previous_defections++;

        if (previous_defections == 2) {
            next_decision = Outcome.DEFECT;
            //This version is forgiving:
            //after two subsequent defections
            //the counter immediately resets.
            previous_defections = 0;
        } else {
            next_decision = Outcome.COOPERATE;
        }
    }
}
