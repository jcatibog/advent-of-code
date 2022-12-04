package net.catibog.advent_of_code.y2022.day3;

import net.catibog.advent_of_code.common.FileUtility;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class RucksackReorganization {
    static final String fileName = "y2022/day3.input.txt";
    public static void main(String[] args) {
        try {
            var file = FileUtility.getFileFromResource(fileName);
            var br = FileUtility.getBufferedFileReader(file);
//            var sum = part1(br);
            var sum = part2(br);

            System.out.println("Sum: " + sum);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int part1(BufferedReader br) throws IOException {
        String st;
        int sum = 0;

        while ((st = br.readLine()) != null) {
            var st1 = st.substring(0, st.length()/2);
            var st2 = st.substring(st.length()/2);

            for (char c : st1.toCharArray()) {
                if (st2.contains(String.valueOf(c))) {
                    sum += getCharPriority(c);
                    break;
                }
            }
        }

        return sum;
    }

    public static int part2(BufferedReader br) throws IOException {
        String st;
        int sum = 0;
        var list = new ArrayList<List<String>>();
        var innerList = new ArrayList<String>();

        while ((st = br.readLine()) != null) {
            if (innerList.size() == 3) {
                list.add(innerList);
                innerList = new ArrayList<>();
            }
            innerList.add(st);
        }
        if (innerList.size() == 3) {
            list.add(innerList);
        }

        var prioritiesList = new ArrayList<Character>();

        for (List<String> l : list) {
            var st1 = l.get(0);
            var st2 = l.get(1);
            var st3 = l.get(2);
            System.out.println(String.format("st1: %s, st2: %s, st3: %s", st1, st2, st3));

            for (char c : st1.toCharArray()) {
                if (st2.contains(String.valueOf(c)) && st3.contains(String.valueOf(c))) {
                    prioritiesList.add(c);
                    break;
                }
            }
        }

        for (char c : prioritiesList) {
            int p = getCharPriority(c);
            System.out.println(String.format("c: %c, value: %d", c, getCharPriority(c)));
            sum += p;
        }

        return sum;
    }

    public static int getCharPriority(char c) {
        int v;
        if (Character.isUpperCase(c)) {
            v = c - 'A' + 27;
        } else {
            v = c - 'a' + 1;
        }
        return v;
    }
}