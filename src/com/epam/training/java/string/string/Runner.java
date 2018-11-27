package com.epam.training.java.string.string;

import com.epam.training.java.string.string.StringExerciseB.TextWorker;

import static com.epam.training.java.string.string.StringExerciseA.sumIntegersFromText;


public class Runner {
    public static void main(String[] args) {
        //Exercise A, #24: Determine the sum of all integers found in the given text.
        String text = "something, 7 34";
        System.out.println(sumIntegersFromText(text) + "\n");

        //Exercise B, #3: Find such a word in the first sentence, which is not in any of the other sentences (in the paragraph).
        String test = "Первое предложение!\n" + "\n" + "Первое предложение с половиной? Второе предложение, в нём перечисляется всякое и т.д.";
        TextWorker textWorkerSecond = new TextWorker();
        textWorkerSecond.parseText(test);
        System.out.println("First sentence's unique words: " + textWorkerSecond.getParagraphs().get(1).findUniqueWords());

    }
}
