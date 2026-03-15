import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Math.max;

public class CarTest {
    Car testCar;
    @BeforeEach
    public void setupTest() {
        this.testCar = new Car("TestCar", new TestNumberGeneratorImpl(0));
    }

    @Test
    public void testCarMovesForwardProperly() {
        for (int i = 0; i < 5; i++) {
            testCar.move();
            Assertions.assertEquals(max(3, i) - 3, testCar.getDistance());
        }
    }
}
