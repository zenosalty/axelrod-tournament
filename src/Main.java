import strategies.blind.*;
import strategies.prescient.Simpleton;

public class Main {
    public static void main(String[] args) {

        int rounds = 10; //set number of rounds

        Player random = new Player(new Random());
        Player simpleton = new Player (new Simpleton());

        Match m = new Match(); // new match

        m.setPlayers(simpleton, random); //set the players
        m.fight(rounds); //and fight

        System.out.println(simpleton.getScore() + " " + random.getScore()); //print scores
    }
}