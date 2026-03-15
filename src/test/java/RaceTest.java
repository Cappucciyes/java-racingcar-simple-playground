import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class RaceTest {
    Race race;
    @Test
    public void testRace() {
        this.race = new Race();
        for (int i = 0 ; i < 5; i++) race.addCar(new Car(Integer.toString(i), new TestNumberGeneratorImpl()));

        for (int i = 0 ; i < 5; i++) race.simulateSingleRound();

        List<String> winners = race.getCurrentWinners();
        Assertions.assertIterableEquals(Arrays.asList("0", "1", "2","3","4"), winners);
    }
}
