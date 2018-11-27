package com.epam.training.java.string.string;

import java.util.Scanner;

public class StringExerciseA {
    public static int sumIntegersFromText(String text) {
        int sum = 0;
        try(Scanner scanner = new Scanner(text)) {

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    sum += Integer.valueOf(scanner.next());
                }else {
                   scanner.skip("\\D");
                }
            }
        }catch (RuntimeException e) {
            System.out.println("exception");
        }
        return sum;
    }

}
