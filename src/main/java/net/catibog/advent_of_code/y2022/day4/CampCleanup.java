package net.catibog.advent_of_code.y2022.day4;

import net.catibog.advent_of_code.common.FileUtility;

import java.util.List;

public class CampCleanup {
    static final String inputFile = "y2022/day4.input.txt";

    public static void main(String[] args) {
        List<String> lines = FileUtility.getLinesFromFile(inputFile);
        int sectionsContained = 0;
        int sectionsOverlapped = 0;
        for (String s : lines) {
            var sections = s.split(",");
            var s1 = new SectionAssignment(sections[0]);
            var s2 = new SectionAssignment(sections[1]);
            if (s1.contains(s2) || s2.contains(s1)) {
                sectionsContained++;
            }
            if (s1.overlaps(s2) || s2.overlaps(s1)) {
                sectionsOverlapped++;
            }
        }
        System.out.println("sections contained: " + sectionsContained);
        System.out.println("sections overlapped: " + sectionsOverlapped);
    }
}
