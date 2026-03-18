import utils.Pair;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> racers;

    Cars(List<Car> racers) {
        this.racers = racers;
    }

    public boolean addCar(Car newCar) {
        return racers.add(newCar);
    }

    public void simulateSingleRound() {
        for (Car racer: this.racers) {
            racer.move();
        }
    }

    public List<Pair<String, Integer>> getRacerInfo() {
        List<Pair<String, Integer>> result = new ArrayList<Pair<String, Integer>>();

        for (Car racer: racers) {
            result.add(new Pair<>(racer.getName(), racer.getDistance()));
        }

        return result;
    }
}
