import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> racers;

    Race() {
        this.racers = new ArrayList<Car>();
    }

    public boolean addCar(Car newRacer) {
        return racers.add(newRacer);
    }

    public void simulateSingleRound() {
        for (Car racer: this.racers) racer.move();
    }

    public List<String> getCurrentWinners() {
        int maxScore = 0;
        List<String> winnerNames = new ArrayList<String>();

        for (Car racer:this.racers) {
            int currentScore = racer.getDistance();
            if (currentScore > maxScore) maxScore = currentScore;
        }

        for (Car racer:this.racers){
            int currentScore = racer.getDistance();
            if (currentScore == maxScore) winnerNames.add(racer.getName());
        }

        return winnerNames;
    }
}
