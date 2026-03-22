import java.util.List;

public class RaceController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Cars cars;
    private final Race race;

    RaceController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.cars = new Cars();
        //경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
        initRace();
        this.race = new Race(cars);
    }

    RaceController(InputView inputView, OutputView outputView, Cars cars) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.cars = cars;
        this.race = new Race(cars);
    }

    public void playRace() {
        //시도할 회수는 몇회인가요?
        int roundNumber = inputView.getRoundNumber();

        for (int i = 0; i < roundNumber; i++){
            race.simulateRounds(1);
            //실행 결과
            outputView.printCurrentRaceState(race.getCurrentState());
        }

        //neo, brown가 최종 우승했습니다.
        outputView.printWinners(race.getCurrentWinners());
    }

    private void initRace() {
        List<String> names = inputView.getNamesFromUser();
        for(String name: names) {
            cars.addCar(new Car(name));
        }
    }
}
