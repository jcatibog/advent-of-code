package net.catibog.advent_of_code.y2022.day2;

import net.catibog.advent_of_code.common.FileUtility;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Objects;

public class RockPaperScissors {
    public static final String fileName = "y2022/day2.input.txt";

    public enum GameOption {
        ROCK,
        PAPER,
        SCISSORS
    }

    public static int getGameOptionScore(GameOption g) {
        return g.ordinal() + 1;
    }

    public static int getGameOptionOutcome(GameOption g1, GameOption g2) {
        if (g1 == g2) return 0;
        else {
            switch (g1) {
                case ROCK -> {
                    if (g2 == GameOption.PAPER) return -1;
                    else return 1;
                }
                case PAPER -> {
                    if (g2 == GameOption.SCISSORS) return -1;
                    else return 1;
                }
                case SCISSORS -> {
                    if (g2 == GameOption.ROCK) return -1;
                    else return 1;
                }
            }
        }

        return 0;
    }

    public static GameOption getGameOptionForOutcome(GameOption g1, String outcome) {
        if (!Objects.equals(outcome, "Y")) {
            if (g1 == GameOption.ROCK) return outcome.equals("X") ? GameOption.SCISSORS : GameOption.PAPER;
            if (g1 == GameOption.PAPER) return outcome.equals("X") ? GameOption.ROCK : GameOption.SCISSORS;
            if (g1 == GameOption.SCISSORS) return outcome.equals("X") ? GameOption.PAPER : GameOption.ROCK;
        }

        return g1;
    }

    public static void main(String[] args) {
        HashMap<Integer, Integer> outcomeScore = new HashMap<>();
        outcomeScore.put(-1, 0);
        outcomeScore.put(0, 3);
        outcomeScore.put(1, 6);

        HashMap<String, GameOption> strategyMapping = new HashMap<>();
        strategyMapping.put("A", GameOption.ROCK);
        strategyMapping.put("X", GameOption.ROCK);
        strategyMapping.put("B", GameOption.PAPER);
        strategyMapping.put("Y", GameOption.PAPER);
        strategyMapping.put("C", GameOption.SCISSORS);
        strategyMapping.put("Z", GameOption.SCISSORS);

        try {
            var file = FileUtility.getFileFromResource(fileName);
            var br = FileUtility.getBufferedFileReader(file);

            String st;
            int totalScore = 0;
            while ((st = br.readLine()) != null) {
                var strategy = st.split(" ");
                var g1 = strategyMapping.get(strategy[0]);
                var g2 = getGameOptionForOutcome(g1, strategy[1]);
                int currentScore = getGameOptionScore(g2);
                int currentOutcomeScore = outcomeScore.get(getGameOptionOutcome(g2, g1));

                System.out.println(String.format("Option score: %d, Outcome score: %d", currentScore, currentOutcomeScore));
                totalScore = totalScore + currentScore + currentOutcomeScore;
            }
            System.out.println("Total score: " + totalScore);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}