package com.epam.model;

import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * Created by Nikolai on 03.12.2015.
 */
public class Word extends Letter {
    static ArrayList<String> letters = new ArrayList<>();

    public Word() {
    }

    @Override
    public ArrayList<String> getComponents() {
        return letters;
    }

    @Override
    public String toStringAll() {
        return "";
    }

    @Override
    public void makeList() {
        if (WHOLE_TEXT.size() > 0) {
            for (String letter : WHOLE_TEXT) {
                Matcher letterMatcher = letterPattern.matcher(letter);
                if (letterMatcher.find()) {
                    letters.add(letterMatcher.group());
                }
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
