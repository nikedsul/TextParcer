package com.epam.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nikolai on 03.12.2015.
 */
public class Word implements BookComponent {

    public Word() {
    }

    @Override
    public ArrayList<String> getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        if (value.size() > 0) {
            for (int i = 0; i < value.size(); i++) {
                Matcher letterMatcher = letterPattern.matcher(value.get(i));
                Matcher whiteSpaceMatcher = whiteSpacePattern.matcher(value.get(i));
                if (letterMatcher.find()) {
                    sb.append(value.get(i));
                    flag = 0;
                } else if (whiteSpaceMatcher.find() && flag == 0) {
                    sb.append("\n");
                    flag++;
                }
            }
        } else {
            return "No symbols have been found!";
        }
        return sb.toString();
    }

    @Override
    public void compose() {
    }
}
