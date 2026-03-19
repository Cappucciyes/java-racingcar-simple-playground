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

    public void tryMovingEveryCar() {
        for (Car racer: this.racers) {
            racer.move();
        }
    }

    public List<String> getMaxDistanceCarNames() {
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
