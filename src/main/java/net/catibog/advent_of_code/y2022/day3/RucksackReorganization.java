package net.catibog.advent_of_code.y2022.day3;

import net.catibog.advent_of_code.common.FileUtility;

import java.io.IOException;
import java.net.URISyntaxException;

public class RucksackReorganization {
    static final String fileName = "y2022/day3.input.txt";
    public static void main(String[] args) {
        try {
            var file = FileUtility.getFileFromResource(fileName);
            var br = FileUtility.getBufferedFileReader(file);

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
            System.out.println("sum: " + sum);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
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

/*
a 1
b 2
c 3
d 4
e 5
f 6
g 7
h 8
i 9
j 10
k 11
l 12
m 13
n 14
o 15
p 16
q 17
r 18
s 19
t 20
u 21
v 22
w 23
x 24
y 25
z 26
 */