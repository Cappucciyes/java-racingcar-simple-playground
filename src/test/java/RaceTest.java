import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    Race race;
    @BeforeEach
    public void testSetup () {
        race = new Race();
    }

    @Test
    public void testSimulateSingleRound() {
        race.addCar(new Car("0", new TestNumberGeneratorImpl(3)));
        race.addCar(new Car("1", new TestNumberGeneratorImpl(9)));

        race.simulateSingleRound();
        List<String> winners = race.getCurrentWinners();
        Assertions.assertEquals(1, winners.size());
        assertThat(winners).hasSameElementsAs(Arrays.asList("1"));

        race.simulateSingleRound();
        winners = race.getCurrentWinners();
        Assertions.assertEquals(2, winners.size());
        assertThat(winners).hasSameElementsAs(Arrays.asList("1", "0"));
    }

    @Test
    public void testRace() {
        this.race = new Race();
        for (int i = 0 ; i < 2; i++) race.addCar(new Car(Integer.toString(i), new TestNumberGeneratorImpl(3)));
        for (int i = 2 ; i < 5; i++) race.addCar(new Car(Integer.toString(i), new TestNumberGeneratorImpl(9)));

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
