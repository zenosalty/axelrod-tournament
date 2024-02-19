import strategies.blind.AlwaysCooperate;
import strategies.blind.AlwaysDefect;
import strategies.blind.Random;
import strategies.prescient.Friedman;
import strategies.prescient.tit4tat.TitForTat;
import strategies.prescient.tit4tat.TitForXTat;

public class Main {
    public static void main(String[] args) {
        int rounds = 10;

        Player tit_for_tat = new Player(new TitForTat());
        Player always_defect = new Player(new AlwaysDefect());
        Player always_cooperate = new Player(new AlwaysCooperate());
        Player friedman = new Player(new Friedman());
        Player random = new Player(new Random());
        Player tit_for_2_tat = new Player(new TitForXTat(2));
        Player tit_for_3_tat = new Player(new TitForXTat(3));

        Match m = new Match();

        m.setPlayers(tit_for_2_tat, random);
        m.fight(rounds);

        System.out.println(tit_for_2_tat.getScore() + " " + random.getScore());
    }
}