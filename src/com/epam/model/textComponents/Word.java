package com.epam.model.textComponents;

import com.epam.model.BookComponent;

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
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : letters) {
            stringBuilder.append(string).append("\n");
        }
        return stringBuilder.toString();
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
        if (BookComponent.WHOLE_TEXT.size() > 0) {
            for (String letter : BookComponent.WHOLE_TEXT) {
                Matcher letterMatcher = BookComponent.letterPattern.matcher(letter);
                if (letterMatcher.find()) {
                    letters.add(letterMatcher.group());
                }
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
