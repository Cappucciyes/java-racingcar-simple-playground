import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Math.max;

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
        if (this.racers.isEmpty()) {
            return new ArrayList<String>();
        }

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
                .orElse(0);
    }
}
