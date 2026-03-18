import utils.RacerInfo;

import java.util.*;

public class Race {
    private final Cars racers;

    Race(Cars racers){
        this.racers = racers;
    }

    public void simulateSingleRound() {
        this.racers.simulateSingleRound();
    }

    public List<String> getCurrentWinners() {
        int maxScore = getMaxScore();

        return this.racers.getRacerInfo().stream()
                .filter(racer -> racer.distance() == maxScore)
                .map(RacerInfo::name)
                .toList();
    }

    private int getMaxScore() {
        return this.racers.getRacerInfo().stream()
                .map(RacerInfo::distance)
                .max(Integer::compare)
                .orElse(-1);
    }
}
