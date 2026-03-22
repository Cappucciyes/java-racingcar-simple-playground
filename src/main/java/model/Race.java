package model;

import java.util.*;

public class Race {
    private final Cars racers;

    public Race(Cars racers){
        this.racers = racers;
    }

    public void simulateRounds(int n) {
        for (int i = 0; i < n; i ++) {
            this.racers.tryMovingEveryCar();
        }
    }

    public List<String> getCurrentWinners() {
        return this.racers.getMaxDistanceCarNames();
    }

    public Map<String, List<Integer>> getCurrentState() {
        return this.racers.getRacerInfo();
    }
}
