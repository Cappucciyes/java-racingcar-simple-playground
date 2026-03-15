public class Car {
    private int distance = 0;
    private String name;
    private NumberGenerator numberGenerator;

    Car(String name) {
        this.name = name;
        this.numberGenerator = new NumberGeneratorImpl();
    }
    Car(String name, NumberGenerator numberGenerator) {
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public void move() {
        int flag = numberGenerator.generateNumber();
        if (flag >= 4) distance += 1;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }
}
