import utils.RacerInfo;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> racers;

    Cars() {
       this.racers = new ArrayList<Car>();
    }
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

    public List<RacerInfo<String, Integer>> getRacerInfo() {
        List<RacerInfo<String, Integer>> result = new ArrayList<RacerInfo<String, Integer>>();

        for (Car racer: racers) {
            result.add(new RacerInfo<>(racer.getName(), racer.getDistance()));
        }

        return result;
    }
}
