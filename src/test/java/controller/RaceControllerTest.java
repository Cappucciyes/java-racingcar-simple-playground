package controller;

import components.ZeroToNineCyclingGenerator;
import model.Car;
import model.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.OutputView;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class RaceControllerTest {
    RaceController raceController;
    Cars cars = new Cars();

    @Test
    @DisplayName("주어진 횟수만큼 자동차를 전진시키려 한다.")
    protected void testPlayRace() {
        //given
        cars.addCar(new Car("alice", new ZeroToNineCyclingGenerator(3)));
        cars.addCar(new Car("bob", new ZeroToNineCyclingGenerator(4)));
        Scanner scanner = new Scanner(new ByteArrayInputStream("2".getBytes()));
        raceController = new RaceController(new InputView(scanner), new OutputView(), cars);

        //when
        raceController.playRace();

        //then
        Map<String, List<Integer>> raceResult = cars.getRacerInfo();
        assertEquals(2, raceResult.size());
        assertEquals(List.of(1), raceResult.get("alice"));
        assertEquals(List.of(2), raceResult.get("bob"));
    }
}