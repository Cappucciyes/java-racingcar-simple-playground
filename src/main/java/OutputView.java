import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class OutputView {
    public void printCurrentRaceState(Map<String, List<Integer>> currentRaceState) {
        for (String name : currentRaceState.keySet()) {
            List<Integer> allDistances = currentRaceState.get(name);

            allDistances.forEach((distance) ->{
                System.out.printf("%s : %s\n", name, getDistanceString(distance));
            });
        }

        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String winnersWithCommas = String.join(", ", winners);
        System.out.printf("%s가 최종 우승했습니다.", winnersWithCommas);
    }

    private String getDistanceString(int n) {
        StringBuilder result = new StringBuilder();

        while (n-->0){
            result.append("-");
        }

        return result.toString();
    }
}
