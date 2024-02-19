/*
 * The concept of Strategy is formalized here
 * as a function which returns an outcome as
 * output. The outcome may be calculated
 * depending on the features of the specific
 * Strategy, but it always assumes one out of
 * two values, which are defined in Outcome.
 *   Strategies are classified into two groups:
 *   - blind: these Strategies compute their
 *     outcome without taking the other
 *     opponent's behaviour into account.
 *   - prescient: the outcome produced by
 *     these Strategies depends on the
 *     opponent's choices.
 */

package strategies;

public interface Strategy {
    Outcome decide();
}