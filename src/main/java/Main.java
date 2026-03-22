public class Main {
    public static void main(String args[]) {
        RaceController raceController = new RaceController(new InputView(), new OutputView());

        raceController.playRace();
    }
}