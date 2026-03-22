package model;

import components.TestNumberGeneratorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Cars cars;
    @BeforeEach
    public void testSetup () {
        cars = new Cars(new ArrayList<Car>());
    }

    @Test
    public void testTryMovingEveryCar() {
        // given
        cars.addCar(new Car("0", new TestNumberGeneratorImpl(9)));
        cars.addCar(new Car("1", new TestNumberGeneratorImpl(9)));

        // when
        cars.tryMovingEveryCar();

        // result
        List<String> winners = cars.getMaxDistanceCarNames();
        Assertions.assertEquals(2, winners.size());
        assertThat(winners).hasSameElementsAs(Arrays.asList("1", "0"));
    }

    @Test
    public void testGetMaxDistanceCarNames() {
        // given
        cars.addCar(new Car(Integer.toString(0), new TestNumberGeneratorImpl(3)));
        cars.addCar(new Car(Integer.toString(1), new TestNumberGeneratorImpl(9)));

        //when
        cars.tryMovingEveryCar();

        // result
        List<String> winners = cars.getMaxDistanceCarNames();
        Assertions.assertEquals(1, winners.size());
        assertThat(winners).hasSameElementsAs(Arrays.asList("1"));
    }

    @Test
    void testGetRacerInfo() {
        // given
        cars.addCar(new Car(Integer.toString(0), new TestNumberGeneratorImpl(3)));
        cars.addCar(new Car(Integer.toString(0), new TestNumberGeneratorImpl(4)));
        cars.addCar(new Car(Integer.toString(1), new TestNumberGeneratorImpl(9)));

        //when
        cars.tryMovingEveryCar();

        // result
        Map<String, List<Integer>> carState = cars.getRacerInfo();
        Assertions.assertEquals(2, carState.size());

        Assertions.assertEquals(2, carState.get("0").size());
        assertThat(carState.get("0")).hasSameElementsAs(Arrays.asList(0,1));
        Assertions.assertEquals(1, carState.get("1").size());
        assertThat(carState.get("1")).hasSameElementsAs(Arrays.asList(1));
    }
}
