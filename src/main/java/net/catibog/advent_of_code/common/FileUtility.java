package net.catibog.advent_of_code.common;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {
    public static File getFileFromResource(String fileName) throws URISyntaxException {
        var classLoader = FileUtility.class.getClassLoader();
        var url = classLoader.getResource(fileName);
        if (url == null) {
            throw new IllegalArgumentException("file not found: " + fileName);
        }

        return new File(url.toURI());
    }

    public static BufferedReader getBufferedFileReader(File file) throws FileNotFoundException {
        return new BufferedReader(new FileReader(file));
    }

    public static List<String> getLinesFromFile(String fileName) {
        var lines = new ArrayList<String>();
        try {
            var file = getFileFromResource(fileName);
            var br = getBufferedFileReader(file);

            String st;
            while ((st = br.readLine()) != null) {
                lines.add(st);
            }
        } catch (URISyntaxException | IOException e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }
}
