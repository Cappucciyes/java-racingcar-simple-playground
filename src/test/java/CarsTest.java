import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    Cars cars;
    @BeforeEach
    public void testSetup () {
        cars = new Cars(new ArrayList<Car>());
    }

    @Test
    public void testGetRacerInfo() {
        cars.addCar(new Car("0", new TestNumberGeneratorImpl(3)));

        List<Pair<String, Integer>> winners = cars.getRacerInfo();
        Assertions.assertEquals(1, winners.size());
        assertThat(winners).hasSameElementsAs(Arrays.asList(
                new Pair<>("0", 0)
        ));

        cars.simulateSingleRound();
        winners = cars.getRacerInfo();
        Assertions.assertEquals(1, winners.size());
        assertThat(winners).hasSameElementsAs(Arrays.asList(
                new Pair<>("0", 0)
        ));

        cars.addCar(new Car("1", new TestNumberGeneratorImpl(9)));
        cars.simulateSingleRound();

        winners = cars.getRacerInfo();
        Assertions.assertEquals(2, winners.size());
        assertThat(winners).hasSameElementsAs(Arrays.asList(
                new Pair<>("0", 1),
                new Pair<>("1", 1)
        ));
    }

    @Test
    public void testSimulateSingleRound() {
        cars.addCar(new Car("0", new TestNumberGeneratorImpl(3)));
        cars.addCar(new Car("1", new TestNumberGeneratorImpl(9)));

        cars.simulateSingleRound();
        List<Pair<String, Integer>> winners = cars.getRacerInfo();
        Assertions.assertEquals(2, winners.size());
        assertThat(winners).hasSameElementsAs(Arrays.asList(
                new Pair<>("0", 0),
                new Pair<>("1", 1)
        ));
    }}
