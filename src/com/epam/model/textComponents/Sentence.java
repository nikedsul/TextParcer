package com.epam.model.textComponents;

import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * Created by Nikolai on 03.12.2015.
 */
public class Sentence extends Word {

    /**
     * The list words contains all the words of the text
     */
    static ArrayList<String> words = new ArrayList<>();

    /** Constructor */
    public Sentence() {
    }

    @Override
    public ArrayList<String> getComponents() {
        return words;
    }

    @Override
    public String toStringAll() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : words) {
            stringBuilder.append(string).append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toStringOne(int componentOrdinal) {
        if ((words.size() - 1) < componentOrdinal) {
            return "There are only " + words.size() + " components in the list!";
        }
        return words.get(componentOrdinal);
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
