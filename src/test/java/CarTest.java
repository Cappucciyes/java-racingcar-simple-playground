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
        // given
        testCar = new Car("Bob");

        //result
        Assertions.assertEquals("Bob", testCar.getName());
    }
    @Test
    public void testCarMovesDoesNotMoveProperly() {
        //given
        this.testCar = new Car("TestCar", new TestNumberGeneratorImpl(0));

        // when
        testCar.move();

        // result
        Assertions.assertEquals(0, testCar.getDistance());
    }

    @Test
    public void testCarMovesProperly() {
        //given
        this.testCar = new Car("TestCar", new TestNumberGeneratorImpl(4));

        for (int i = 1; i <= 2; i++) {
            // when
            testCar.move();
            // result
            Assertions.assertEquals(i, testCar.getDistance());
        }
    }
}
