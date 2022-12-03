package net.catibog.advent_of_code.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;

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
}
