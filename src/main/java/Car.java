public class Car {
    public int distance = 0;
    private NumberGeneratorImpl numberGenerator;

    Car() {
       this.numberGenerator = new NumberGeneratorImpl();
    }
    Car(NumberGeneratorImpl numberGenerator) {
       this.numberGenerator = numberGenerator;
    }

    public void move() {
        int flag = numberGenerator.generateNumber();

        if (flag >= 4) distance += 1;
    }
}
