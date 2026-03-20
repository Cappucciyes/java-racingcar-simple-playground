public class Car {
    private int distance = 0;
    private final String name;
    private final NumberGenerator numberGenerator;

    Car(String name) {
        this.name = name;
        this.numberGenerator = new NumberGeneratorImpl();
    }
    Car(String name, NumberGenerator numberGenerator) {
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public void move() {
        boolean canMove = numberGenerator.generateNumber() >= 4;
        if (canMove) {
            distance += 1;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }
}
