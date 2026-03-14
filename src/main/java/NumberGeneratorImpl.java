import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator {

   Random random = new Random();

    public int generateNumber() {
        return random.nextInt(0,10);
    }
}
