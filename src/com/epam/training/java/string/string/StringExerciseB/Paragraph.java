package com.epam.training.java.string.string.StringExerciseB;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Paragraph {
    private List<Sentence> sentences = new ArrayList<>();

    public Paragraph(String text) {
        List<String> tSentences = new ArrayList<>();
        Pattern pattern = Pattern.compile("(^|(?<=[.!?]\\s))(\\d+\\.\\s?)*[А-ЯA-Z][^!?]*?[.!?](?=\\s*(\\d+\\.\\s)*[А-ЯA-Z]|$)", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            tSentences.add(matcher.group());
        }
        for (String s : tSentences)
            sentences.add(new Sentence(s));
    }

    public Paragraph() {
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public int getTotalWords() {
        int totalWords = 0;
        for (Sentence sentence : sentences) {
            totalWords += sentence.getWords().size();
        }
        return totalWords;
    }

    public int getTotalPunctuationMarks() {
        int totalMarks = 0;
        for (Sentence sentence : sentences) {
            totalMarks += sentence.getPunctuationMarks().size();
        }
        return totalMarks;
    }

    //main task: to find a word in the first sentence that doesn't appear in any other of this paragraph

    public List<String> findUniqueWords() {
        List<String> uniqueWords = new ArrayList<>();
        for (String word : sentences.get(0).getWords()) {
            boolean isUnique = true;
            for (ListIterator<Sentence> sentenceIterator = sentences.listIterator(1); sentenceIterator.hasNext();) {
                for (String otherWord : sentenceIterator.next().getWords()) {
                if(otherWord.equals(word)){
                    isUnique = false;
                }
                }
            }
            if(isUnique == true){
                uniqueWords.add(word);
            }
        }
        return uniqueWords;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("Paragraph{sentences=");
        for(Sentence sentence : sentences) {
            stringBuilder.append(sentence.getValue());
            stringBuilder.append(" ");
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
