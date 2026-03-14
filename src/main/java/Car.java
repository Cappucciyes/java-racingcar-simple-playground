public class Car {
    public int distance = 0;
    private String name;
    private NumberGeneratorImpl numberGenerator;

    Car(String name) {
        this.name = name;
        this.numberGenerator = new NumberGeneratorImpl();
    }
    Car(String name, NumberGeneratorImpl numberGenerator) {
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
}
