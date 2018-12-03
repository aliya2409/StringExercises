package com.epam.training.java.string.string.StringExerciseB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sentence {
    public static final String WHITE_SPACE = "\\s";
    public static final String PUNCTUATION = "\\p{P}";
    private String value;
    private List<String> lexemes = new ArrayList<>();
    private List<String> words = new ArrayList<>();
    private List<String> punctuationMarks = new ArrayList<>();

    public Sentence(String text) {
        this.value = text;
    }

    public void parseSentence() {
        StringBuilder sb = new StringBuilder(value);
        String[] lookForArray = {",", ";", ":", ".", "!", "?"};
        List<String> lexemesToChange = new ArrayList<>();
        try (Scanner scanner = new Scanner(value)) {
            while (scanner.hasNext()) {
                lexemesToChange.add(scanner.next());
            }
        }

        for (String lexeme : lexemesToChange) {
            for (String lookFor : lookForArray) {
                if (lexeme.endsWith(lookFor)) {
                    StringBuilder newLexeme = new StringBuilder(lexeme);
                    int lastIndex = lexeme.lastIndexOf(lookFor);
                    newLexeme.insert(lastIndex, " ");
                    String newLexemeString = newLexeme.toString();
                    lexemesToChange.set(lexemesToChange.indexOf(lexeme), newLexemeString);
                }
            }
        }

        StringBuilder modifiedSentence = new StringBuilder();
        for (String lexeme : lexemesToChange) {
            modifiedSentence.append(lexeme).append(" ");
        }

        String newText = modifiedSentence.toString();
        String[] splitLexemes = newText.split(WHITE_SPACE);

        for (String lexeme : splitLexemes) {
            lexemes.add(lexeme);
            filterLexemes(lexeme);
        }
    }

    private void filterLexemes(String lexeme) {
        if (lexeme.matches(PUNCTUATION)) {
            punctuationMarks.add(lexeme);
        } else {
            words.add(lexeme);
        }
    }

    public Sentence() {
    }

    public String getValue() {
        return value;
    }

    public List<String> getLexemes() {
        return lexemes;
    }

    public List<String> getWords() {
        return words;
    }

    public List<String> getPunctuationMarks() {
        return punctuationMarks;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "value='" + value + '\'' +
                '}';
    }
}

