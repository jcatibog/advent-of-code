package net.catibog.advent_of_code.y2022.day1;

import net.catibog.advent_of_code.common.FileUtility;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CalorieCounting {
    public static final String fileName = "y2022/day1/input.txt";
    public static void main(String[] args) {
        try {
            File file = FileUtility.getFileFromResource(fileName);
            var br = FileUtility.getBufferedFileReader(file);

            var pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
            var current = 0;
            var top3 = 0;
            String st;

            while ((st = br.readLine()) != null) {
                if (st.equals("")) {
                    pq.add(current);
                    current = 0;
                } else {
                    int value = Integer.parseInt(st);
                    current += value;
                }
            }

            System.out.printf("Max: %d%n", pq.peek());
            for (int i = 0; i < 3; i++) {
                top3 += pq.remove();
            }
            System.out.printf("Top 3: %d%n", top3);
        } catch (URISyntaxException urie) {
            System.out.println("Could not process input file");
        } catch (IOException ioe) {
            System.out.println("Error reading line");
        }
    }
}
