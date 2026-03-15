public class TestNumberGeneratorImpl implements NumberGenerator {
    private int number;

    TestNumberGeneratorImpl(int startingNumber) {
        this.number = startingNumber;
    }

    public int generateNumber() {
        int result = number;
        number = (number + 1) % 10;
        return result;
    }
}
