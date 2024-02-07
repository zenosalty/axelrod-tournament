import strategies.blind.AlwaysCooperate;
import strategies.blind.AlwaysDefect;
import strategies.prescient.TitForTat;

public class Main {
    public static void main(String[] args) {
        Match m1 = new Match(new TitForTat(), new AlwaysCooperate());
        Match m2 = new Match(new TitForTat(), new AlwaysDefect());

        m1.fight(10);
        m2.fight(10);

        System.out.println("TFT: " + m1.getP1Points() + " AC: " + m1.getP2Points());
        System.out.println("TFT: " + m1.getP1Points() + " AD: " + m2.getP2Points());
    }
}