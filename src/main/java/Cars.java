import java.util.List;

public class Cars {
    private final List<Car> racer;
    Cars(List<Car> racer) {
        this.racer = racer;
    }

    public void addCarr(Car newCar) {
        racer.add(newCar);
    }

    public List<Car> getRacer() {
        return List.copyOf(racer);
    }
}
