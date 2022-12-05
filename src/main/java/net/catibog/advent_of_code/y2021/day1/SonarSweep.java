package net.catibog.advent_of_code.y2021.day1;

import net.catibog.advent_of_code.common.FileUtility;

import java.util.List;

public class SonarSweep {
    static final String inputFile = "y2021/day1.input.txt";

    public static void main(String[] args) {
        var lines = FileUtility.getLinesFromFile(inputFile);
        var numIncreases = part1(lines);
        numIncreases = part2(lines);
        System.out.println(numIncreases);
    }

    public static int part1(List<String> lines) {
        int last = Integer.MAX_VALUE;
        int numIncreases = 0;

        for (String s : lines) {
            var value = Integer.parseInt(s);
            if (value > last) {
                numIncreases++;
            }
            last = value;
        }

        return numIncreases;
    }

    public static int part2(List<String> lines) {
        List<Integer> ints = lines.stream().map(Integer::parseInt).toList();
        int window1 = ints.subList(0, 3).stream().reduce(Integer::sum).get();
        int numIncreases = 0;

        for (int i = 3; i < ints.size(); i++) {

        }

        return numIncreases;
    }


}
