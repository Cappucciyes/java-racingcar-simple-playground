package components;

public class ZeroToNineCyclingGenerator implements NumberGenerator {
    private int number;

    public ZeroToNineCyclingGenerator() {
        this.number = 0;
    }

    public ZeroToNineCyclingGenerator(int startingNumber) {
        this.number = startingNumber;
    }

    @Override
    public int generateNumber() {
        int result = number;
        number = (number + 1) % 10;
        return result;
    }
}
