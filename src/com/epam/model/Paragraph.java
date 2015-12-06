package com.epam.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;

/**
 * Created by Nikolai on 03.12.2015.
 */
public class Paragraph extends Sentence {

    /**
     * The list sentences contains all the sentences of the text
     */
    static ArrayList<String> sentences = new ArrayList<>();

    public Paragraph() {
    }

    @Override
    public ArrayList<String> getComponents() {
        return sentences;
    }

    @Override
    public String toStringAll() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbFinal = new StringBuilder();
        if (WHOLE_TEXT.size() > 0) {
            for (int i = 0; i < WHOLE_TEXT.size(); i++) {
                sb.append(WHOLE_TEXT.get(i));

                if (WHOLE_TEXT.get(i).equals("\n")) {
                    Matcher paragraphMatcher = paragraphPattern.matcher(sb.toString());
                    if (paragraphMatcher.find()) {
                        sbFinal.append(sb.toString().trim()).append("\n");
                    }
                    sb.delete(0, Integer.MAX_VALUE).trimToSize();
                }
            }
        } else {
            return "No sentences have been found!";
        }
        return sbFinal.toString();
    }

    @Override
    public String toStringOne(int componentOrdinal) {
        if ((sentences.size() - 1) < componentOrdinal) {
            return "There are only " + sentences.size() + " components in the list!";
        }
        return sentences.get(componentOrdinal);
    }

    @Override
    public void makeList() {
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        if (WHOLE_TEXT.size() > 0) {
            for (int i = 0; i < WHOLE_TEXT.size(); i++) {
                Matcher sentenceEndMatcher = sentenceEndPattern.matcher(WHOLE_TEXT.get(i));
                Matcher whiteSpaceMatcher = whiteSpacePattern.matcher(WHOLE_TEXT.get(i));
                sb.append(WHOLE_TEXT.get(i));

                if (sentenceEndMatcher.find() || WHOLE_TEXT.get(i).equals("\n")) {
                    flag++;
                }

                if (flag != 0 && whiteSpaceMatcher.find()) {
                    Matcher sentenceMatcher = sentencePattern.matcher(sb.toString());
                    if (sentenceMatcher.find()) {
                        sentences.add(sb.toString().trim());
                    }
                    sb.delete(0, Integer.MAX_VALUE);
                    flag = 0;
                }
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Method makeHashMapRepeated creates a HashMap of repeated words from only sentences (no code!) of the text
     * @return
     */
    private HashMap makeHashMapRepeated() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentences.size(); i++) {
            sb.append(sentences.get(i));
        }
        String[] onlyWords = sb.toString().split("(\\s|\\p{Punct}\\s)");

        List<String> list = Arrays.asList(onlyWords);

        HashMap<String, Integer> hashMap = new HashMap<>();
        Integer counter;
        for (String i : list) {
            counter = hashMap.get(i);
            hashMap.put(i, counter == null ? 1 : counter + 1);
        }

        for (Object key : hashMap.keySet().toArray()) {

            if (hashMap.get(key) == 1) {

                hashMap.remove(key);
            }
        }

        return hashMap;
    }

    /**
     * Method printRepeatedWords returns a string with all repeated words in sentences (no code!) of the text
     * @return
     */
    public String printRepeatedWords() {
        StringBuilder s = new StringBuilder();
        for (Object value : makeHashMapRepeated().keySet()) {
            s.append(value.toString()).append(" is found in the sentences: ");
            for (int i = 0; i < sentences.size(); i++) {
                if (sentences.get(i).contains(value.toString())) {
                    s.append(i).append(" ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }
}
