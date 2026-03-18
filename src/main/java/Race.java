import utils.Pair;

import java.util.*;

public class Race {
    private final Cars racers;

    Race() {
        this.racers = new Cars(new ArrayList<Car>());
    }

    Race(List<Car> racers){
        this.racers = new Cars(racers);
    }

    public boolean addCar(Car newRacer) {
        return racers.addCar(newRacer);
    }

    public void simulateSingleRound() {
        this.racers.simulateSingleRound();
    }

    public List<String> getCurrentWinners() {
        int maxScore = getMaxScore();

        return this.racers.getRacerInfo().stream()
                .filter(racer -> racer.distance() == maxScore)
                .map(Pair::name)
                .toList();
    }

    private int getMaxScore() {
        return this.racers.getRacerInfo().stream()
                .map(Pair::distance)
                .max(Integer::compare)
                .orElse(-1);
    }
}
