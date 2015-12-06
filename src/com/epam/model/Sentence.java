package com.epam.model;

import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * Created by Nikolai on 03.12.2015.
 */
public class Sentence extends Word {

    static ArrayList<String> words = new ArrayList<>();

    public Sentence() {
    }

    @Override
    public ArrayList<String> getComponents() {
        return words;
    }

    @Override
    public String toStringAll() {
        return words.toString();
    }

    @Override
    public void makeList() {
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        if (WHOLE_TEXT.size() > 0) {
            for (int i = 0; i < WHOLE_TEXT.size(); i++) {
                Matcher letterMatcher = letterPattern.matcher(WHOLE_TEXT.get(i));
                Matcher whiteSpaceMatcher = whiteSpacePattern.matcher(WHOLE_TEXT.get(i));
                if (letterMatcher.find()) {
                    sb.append(WHOLE_TEXT.get(i));
                    flag = 0;
                }
                if (whiteSpaceMatcher.find() && flag == 0) {
                    words.add(sb.toString());
                    sb.delete(0, Integer.MAX_VALUE);
                    flag++;
                }
            }
        } else {
            throw new UnsupportedOperationException();
        }

    }
}
