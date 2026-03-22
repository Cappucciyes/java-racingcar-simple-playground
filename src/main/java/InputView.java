import constants.ErrorMessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String ENTER_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ENTER_ROUND_NUMBER = "시도할 회수는 몇회인가요?";
    private static final String CAR_NAME_DELIMITER = ",";
    private static final int CAR_NAME_LIMIT = 5;
    private static final String NAME_REGEX_PATTERN = "^[\\p{L}\\p{N}]+$";

    private final Scanner scanner;

    InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public List<String> getNamesFromUser() {
        System.out.println(ENTER_CAR_NAMES);
        String userInput = scanner.nextLine();

        return this.parseIntoNames(userInput);
    }

    public int getRoundNumber() {
        System.out.println(ENTER_ROUND_NUMBER);
        String userInput = scanner.nextLine();
        checkIfInputIsInteger(userInput);

        return Integer.parseInt(userInput);
    }

    private List<String> parseIntoNames(String inputFromUser) {
        List<String> result = new ArrayList<String>();

        for (String x: inputFromUser.split(CAR_NAME_DELIMITER)) {
            String strippedName = x.strip();
            checkNameHasOtherDelimiters(strippedName);
            checkNameLength(strippedName);

            result.add(strippedName);
        }

        return result;
    }

    private void checkNameLength(String name) {
        if (name.length() > CAR_NAME_LIMIT) {
            throw new IllegalArgumentException(ErrorMessage.NAME_TOO_LONG);
        }
    }

    private void checkNameHasOtherDelimiters(String name) {
        if (!name.matches(NAME_REGEX_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_INPUT_NOT_CORRECT_FORMAT);
        }
    }

    private void checkIfInputIsInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_NOT_INTEGER);
        }
    }
}
