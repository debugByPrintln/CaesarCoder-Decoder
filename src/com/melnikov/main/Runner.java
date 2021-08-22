package com.melnikov.main;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class Runner {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Do you want to code or decode the message? (1 - code, 2 - decode)");

        if (scanner.nextInt() == 1){
            System.out.println("Type shift: ");
            int shift = scanner.nextInt();
            System.out.println("Type path to text file that you want to code: ");
            String inputString = scanner.next();
            String[] inputPathString = inputString.split("/");

            System.out.println("Type path to output file: ");
            String outputString = scanner.next();
            String[] outputPathString = outputString.split("/");

            Path input = Path.of(inputPathString[0], getOthers(inputPathString));
            Path output = Path.of(outputPathString[0], getOthers(outputPathString));

            try {
                Coder.codeFile(input, output, shift);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if (scanner.nextInt() == 2){
            System.out.println("Type shift: ");
            int shift = scanner.nextInt();
            System.out.println("Type path to text file that you want to decode: ");
            String inputString = scanner.next();
            String[] inputPathString = inputString.split("/");

            System.out.println("Type path to output file: ");
            String outputString = scanner.next();
            String[] outputPathString = outputString.split("/");

            Path input = Path.of(inputPathString[0], getOthers(inputPathString));
            Path output = Path.of(outputPathString[0], getOthers(outputPathString));

            try {
                Coder.decodeFile(input, output, shift);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else {
            throw new UnsupportedOperationException("You can type only \"1\" or \"2\".");
        }


    }

    private static String[] getOthers(String[] strings){
        String[] otherInput = new String[strings.length-1];
        for (int i = 0; i < strings.length-1; i++) {
            otherInput[i] = strings[i+1];
        }
        return otherInput;
    }
}
