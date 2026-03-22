package model;

import components.TestNumberGeneratorImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    Cars currentCars;
    Race race;

    @BeforeEach
    public void testSetup () {
        currentCars = new Cars();
        race = new Race(currentCars);
    }

    @Test
    public void testSimulateRoundsWhenEmpty() {
        // given
        List<String> winners = race.getCurrentWinners();
        Assertions.assertEquals(0, winners.size());

        // when
        race.simulateRounds(1);

        // result
        winners = race.getCurrentWinners();
        Assertions.assertEquals(0, winners.size());
    }

    @Test
    public void testSimulateRounds() {
        currentCars.addCar(new Car(Integer.toString(0), new TestNumberGeneratorImpl(0)));
        currentCars.addCar(new Car(Integer.toString(1), new TestNumberGeneratorImpl(1)));
        currentCars.addCar(new Car(Integer.toString(9), new TestNumberGeneratorImpl(9)));

        List<String> winners = race.getCurrentWinners();
        Assertions.assertEquals(3, winners.size());

        race.simulateRounds(1);
        winners = race.getCurrentWinners();
        Assertions.assertEquals(1, winners.size());
        assertThat(winners).hasSameElementsAs(Arrays.asList("9"));

        race.simulateRounds(3);
        winners = race.getCurrentWinners();
        Assertions.assertEquals(2, winners.size());
        assertThat(winners).hasSameElementsAs(Arrays.asList("9","1"));
    }
}
