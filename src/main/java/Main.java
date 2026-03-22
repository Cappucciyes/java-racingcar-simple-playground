import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        RaceController raceController = new RaceController(new InputView(new Scanner(System.in)), new OutputView());

        raceController.playRace();
    }
}