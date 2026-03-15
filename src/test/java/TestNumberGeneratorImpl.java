public class TestNumberGeneratorImpl implements NumberGenerator {
    private int number;

    TestNumberGeneratorImpl() {
        this.number = 0;
    }

    TestNumberGeneratorImpl(int startingNumber) {
        this.number = startingNumber;
    }

    @Override
    public int generateNumber() {
        int result = number;
        number = (number + 1) % 10;
        return result;
    }
}
