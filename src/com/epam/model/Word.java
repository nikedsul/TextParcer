package com.epam.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nikolai on 03.12.2015.
 */
public class Word implements BookComponent {

    private static Pattern pattern = RegexPattern.WORD_PATTERN.name;

    public Word() {
    }

    public Pattern getPattern() {
        return pattern;
    }

    @Override
    public ArrayList<String> getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (value.size() > 0) {
            for (int i = 0; i < value.size(); i++) {
                Matcher matcher = pattern.matcher(value.get(i));
                if (!matcher.find()) {
                    sb.append(value.get(i));
                } else {
                    sb.append("\n");
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
