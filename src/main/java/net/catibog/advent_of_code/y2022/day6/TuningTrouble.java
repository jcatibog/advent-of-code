package net.catibog.advent_of_code.y2022.day6;

import net.catibog.advent_of_code.common.FileUtility;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TuningTrouble {
    private static final String inputFile = "y2022/day6.input.txt";

    public static void main(String[] args) {
        var line = FileUtility.getLinesFromFile(inputFile).get(0);
        System.out.println(line);
        for (int i = 0; i < line.length() - 14; i++) {
//            Set<Character> packetMarker = line.substring(i, i+4).chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
//            if (packetMarker.size() == 4) {
//                System.out.format("index: %d%n", i+4);
//                break;
//            }
            Set<Character> messageMarker = line.substring(i, i+14).chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
            if (messageMarker.size() == 14) {
                System.out.format("index: %d%n", i+14);
                break;
            }
        }
    }
}
