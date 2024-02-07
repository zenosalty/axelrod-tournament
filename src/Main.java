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

        new Match(tit_for_tat, always_defect, rounds);
        new Match(tit_for_tat, always_cooperate, rounds);
        new Match(tit_for_tat, friedman, rounds);
        new Match(always_defect, always_cooperate, rounds);
        new Match(always_defect, friedman, rounds);
        new Match(always_cooperate, friedman);

        new Match(random, tit_for_tat, rounds);
        new Match(random, always_cooperate, rounds);
        new Match(random, always_defect, rounds);
        new Match(random, friedman, rounds);
        System.out.println("TFT: " + tit_for_tat.getScore());
        System.out.println("ADF: " + always_defect.getScore());
        System.out.println("ACP: " + always_cooperate.getScore());
        System.out.println("FRD: " + friedman.getScore());
        System.out.println("RND: " + random.getScore());
    }
}