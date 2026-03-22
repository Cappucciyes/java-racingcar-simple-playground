import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);
    public List<String> getNamesFromUser() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String userInput = scanner.nextLine();

        List<String> result = this.parseIntoNames(userInput);

        return result;
    }

    public int getRoundNumber() {
        System.out.println("시도할 회수는 몇회인가요?");
        String userInput = scanner.nextLine();

        return Integer.parseInt(userInput);
    }


    private List<String> parseIntoNames(String inputFromUser) {
        List<String> result = new ArrayList<String>();

        for (String x: inputFromUser.split(",")) {
            result.add(x.strip());
        }

        return result;
    }


}
