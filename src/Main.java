import strategies.Strategy;
import strategies.blind.AlwaysCooperate;
import strategies.blind.AlwaysDefect;
import strategies.blind.Random;
import strategies.prescient.Friedman;
import strategies.prescient.TitForTat;

public class Main {
    public static void main(String[] args) {
        int rounds = 10;

        Player tit_for_tat = new Player(new TitForTat());
        Player always_defect = new Player(new AlwaysDefect());
        Player always_cooperate = new Player(new AlwaysCooperate());
        Player friedman = new Player(new Friedman());
        Player random = new Player(new Random());

        Match m = new Match();

        m.setPlayers(tit_for_tat, random);
        m.fight(rounds);

        System.out.println(tit_for_tat.getScore() + " " + random.getScore());
    }
}