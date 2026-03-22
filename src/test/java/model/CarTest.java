package model;

import components.TestNumberGeneratorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    Car testCar;
    @BeforeEach
    public void setupTest() {
        this.testCar = new Car("TestCar", new TestNumberGeneratorImpl());
    }

    @Test
    @DisplayName("자동차는 이름을 가진다")
    public void testCarHasName() {
        // given
        testCar = new Car("Bob");

        //result
        Assertions.assertEquals("Bob", testCar.getName());
    }
    @Test
    @DisplayName("자동차는 4 미만일 때 전진하지 않는다.")
    public void testCarMovesDoesNotMoveProperly() {
        //given
        this.testCar = new Car("TestCar", new TestNumberGeneratorImpl(0));

        // when
        testCar.move();

        // result
        Assertions.assertEquals(0, testCar.getDistance());
    }

    @Test
    @DisplayName("자동차는 4 이상일 때 앞으로 전진한다.")
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
