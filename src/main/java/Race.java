import java.util.*;

public class Race {
    private final List<Car> racers;

    Race() {
        this.racers = new ArrayList<Car>();
    }

    Race(List<Car> racers){
        this.racers = racers;
    }

    public boolean addCar(Car newRacer) {
        return racers.add(newRacer);
    }

    public void simulateSingleRound() {
        for (Car racer: this.racers) racer.move();
    }

    public List<String> getCurrentWinners() {
        int maxScore = getMaxScore();

        return this.racers.stream()
                .filter(racer -> racer.getDistance() == maxScore)
                .map(Car::getName)
                .toList();
    }

    private int getMaxScore() {
        return this.racers.stream()
                .map(Car::getDistance)
                .max(Integer::compare)
                .orElse(-1);
    }
}
