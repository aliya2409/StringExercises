package com.epam.training.java.string.string;

import java.util.Scanner;

public class StringExerciseA {

    public static final String NON_DIGITS = "\\D";

    public static int sumIntegersFromText(String text) {
        int sum = 0;
        try (Scanner scanner = new Scanner(text)) {

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    sum += Integer.valueOf(scanner.next());
                } else {
                    scanner.skip(NON_DIGITS);
                }
            }
        }
        return sum;
    }

}
