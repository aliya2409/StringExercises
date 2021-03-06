package com.epam.training.java.string.string.StringExerciseB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class TextWorker {
    public static final String PARAGRAPH_DELIMITER = "\\s*^\\s*$\\s*";
    private List<Paragraph> paragraphs = new ArrayList<>();


    public void parseText(String text) {
        List<String> tParagraphs = new ArrayList<>();
        try (Scanner scanner = new Scanner(text)) {
            scanner.useDelimiter(Pattern.compile(PARAGRAPH_DELIMITER, Pattern.MULTILINE));
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    sb.append(line).append(' ');
                } else {
                    tParagraphs.add(sb.substring(0, sb.length() - 1));
                    sb.setLength(0);
                }
            }
            if (sb.length() > 0) {
                tParagraphs.add(sb.substring(0, sb.length() - 1));
            }
        }
        for (String paragraph : tParagraphs) {
            paragraphs.add(new Paragraph(paragraph));
        }
        parseParagraphs();
    }

    private void parseParagraphs() {
        for (Paragraph paragraph : paragraphs) {
            paragraph.parseParagraph();
            for (Sentence sentence : paragraph.getSentences()) {
                sentence.parseSentence();
            }
        }
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Paragraph{sentences=");
        for (Paragraph paragraph : paragraphs) {
            stringBuilder.append(paragraph.toString());
            stringBuilder.append("\n");
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

