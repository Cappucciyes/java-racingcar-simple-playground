package controller;

import components.ZeroToNineCyclingGenerator;
import model.Car;
import model.Cars;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputView;
import view.OutputView;

import javax.print.DocFlavor;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RaceControllerTest {
    RaceController raceController;
    Cars cars = new Cars();

    @Test
    @DisplayName("통합 테스트 : 주어진 횟수만큼 자동차를 전진시키려 한다.")
    protected void testPlayRace() {
        //given
        cars.addCar(new Car("alice", new ZeroToNineCyclingGenerator(4)));
        Scanner scanner = new Scanner(new ByteArrayInputStream("3".getBytes()));
        raceController = new RaceController(new InputView(scanner), new OutputView(), cars);

        //when
        raceController.playRace();

        //then
        Map<String, List<Integer>> raceResult = cars.getRacerInfo();
        assertEquals(1, raceResult.size());
        assertEquals(List.of(3), raceResult.get("alice"));
    }

    @Test
    @DisplayName("통합 테스트 : RaceController가 Cars를 생성하는데 문제가 없다")
    protected void raceControllerCanBuildItsOwnCarsWithUserInput() {
        //given
        Scanner scanner = new Scanner(new ByteArrayInputStream("alice,bob\n3\n".getBytes()));
        raceController = new RaceController(new InputView(scanner), new OutputView());

        //when
        raceController.playRace();
    }
}