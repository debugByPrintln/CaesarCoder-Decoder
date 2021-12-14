package com.melnikov.main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class TestRunner {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("resources", "plainDir", "plain.txt");
        Files.writeString(path, ("\n" + "hi" + "\n" + "hi"), StandardOpenOption.APPEND);
        String string = Files.readString(path);
        System.out.println(string);
        String[] strings = new String[11];
        Runner.main(strings);
    }
}
