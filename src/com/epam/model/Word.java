package com.epam.model;

import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * Created by Nikolai on 03.12.2015.
 */
public class Word extends Letter {

    /**
     * The list letters contains all the letters of the text
     */
    static ArrayList<String> letters = new ArrayList<>();

    /** Constructor */
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
    public String toStringOne(int componentOrdinal) {
        if ((letters.size() - 1) < componentOrdinal) {
            return "There are only " + letters.size() + " components in the list!";
        }
        return letters.get(componentOrdinal);
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
