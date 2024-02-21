/*
 * While Tit-For-X-Tat becomes more difficult
 * to provoke as X approaches +infinity,
 * X-Tit-For-Tat redeems (that is, chooses
 * cooperation as its next outcome) only those
 * Strategies which are able to "think twice"
 * and cooperate back enough times (X) to gain
 * X-Tit-For-Tat's trust.
 *   Let us consider some extreme scenarios,
 * which depend on the value of X:
 *   - X = +infinity: this means that another
 *     Strategy would need to cooperate back
 *     forever in order to apologize to X-Tit-For-Tat
 *     (even after a single defection!).
 *     This observation demonstrates that
 *     Friedman belongs to this set of Strategies.
 *   - X <= 0: in this case, X-Tit-For-Tat always
 *     trusts its opponents regardless of their
 *     behaviour: AlwaysCooperate belongs to this
 *     set.
 *
 * //TODO
 * WARNING: the definition given above may not be
 * equivalent to the others that can be found on
 * the Internet:
 *
 * //TODO (tow tits for tat) TTFT
 *    Two tits for tat is welcoming
 *    but replies to each retaliation
 *    by two defections.
 *
 * The description that has just been given is
 * actually ambiguous: what does "each retaliation"
 * mean? Does TTFT remember every single defection
 * of the opponent and then retaliates back twice
 * that amount, using a sort of "cumulative approach"?
 * Or does it just keep track of the last two rounds
 * and then keeps retaliating if the opponent
 * defected at least once in that window?
 *
 * From now on, we will stick to the second
 * interpretation.
 *
 * Let us demonstrate the equivalence informally:
 * given the definition for xtft, suppose that
 * this Strategy has just entered the "untrustworthy"
 * state, in which xtft is waiting for the opponent
 * to apologize.
 * In order to accomplish this task, xtft needs to
 * "look back" in history to see whether the opponent
 * cooperated enough times (x). In other words, in
 * the last x rounds there must be no sign of defection.
 * If the opponent defected inside the window x,
 * xtft would continue retaliating. In other words,
 * each defection of the opponent is followed by
 * x retaliations by xtft, until the window
 * x is filled only by cooperation.
 *                                              #
 */

package strategies.prescient.tit4tat;

import strategies.Outcome;
import strategies.prescient.PrescientStrategy;

public class XTitForTat extends PrescientStrategy {

    private int x;
    private int previous_coop;

    public XTitForTat(int x) {
        super();
        this.x = x;
        previous_coop = x;
    }

    @Override
    public void prepareNextDecision(Outcome o) {
        if (Outcome.DEFECT == o)
            previous_coop = 0;
        else
            previous_coop++; //overflow is unlikely to happen, but p_c += p_c < x ? 1 : 0

        next_decision = previous_coop >= x ? Outcome.COOPERATE : Outcome.DEFECT;
    }

    public String toString() {
        return x + "TFT";
    }
}
