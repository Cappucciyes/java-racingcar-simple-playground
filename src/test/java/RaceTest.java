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
    public void testGetCurrentWinners() {
        Assertions.assertTrue(race.getCurrentWinners().isEmpty());

        for (int i = 0 ; i < 2; i++) {
            currentCars.addCar(new Car(Integer.toString(i), new TestNumberGeneratorImpl(3)));
        }
        for (int i = 2 ; i < 5; i++) {
            currentCars.addCar(new Car(Integer.toString(i), new TestNumberGeneratorImpl(9)));
        }

        race.simulateSingleRound();
        List<String> winners = race.getCurrentWinners();
        Assertions.assertEquals(3, winners.size());
        assertThat(winners).hasSameElementsAs(Arrays.asList("2","3","4"));

        race.simulateSingleRound();
        race.simulateSingleRound();

        winners = race.getCurrentWinners();
        Assertions.assertEquals(2, winners.size());
        assertThat(winners).hasSameElementsAs(Arrays.asList("0","1"));
    }
}
