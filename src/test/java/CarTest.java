import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Math.max;

public class CarTest {
    Car testCar;
    @BeforeEach
    public void setupTest() {
        this.testCar = new Car("TestCar", new TestNumberGeneratorImpl());
    }

    @Test
    public void testCarHasName() {
        testCar = new Car("Bob");
        Assertions.assertEquals("Bob", testCar.getName());
        testCar = new Car("Alice");
        Assertions.assertEquals("Alice", testCar.getName());
    }
    @Test
    public void testCarMovesForwardProperly() {
        for (int i = 0; i < 5; i++) {
            testCar.move();
            Assertions.assertEquals(max(3, i) - 3, testCar.getDistance());
        }
    }
}
