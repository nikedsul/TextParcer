package com.epam.model;

import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * Created by Nikolai on 03.12.2015.
 */
public class Paragraph extends Sentence {

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
                        sbFinal.append(sb.toString().trim() + "\n");
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
        return super.toStringOne(componentOrdinal);
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
}
