package com.epam.model;

import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * Created by Nikolai on 03.12.2015.
 */
public class Sentence extends Word {


    public Sentence() {
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
                Matcher symbolMatcher = symbolPattern.matcher(value.get(i));
                Matcher sentenceEndMatcher = sentenceEndPattern.matcher(value.get(i));
                Matcher whiteSpaceMatcher = whiteSpacePattern.matcher(value.get(i));
                if (symbolMatcher.find()) {
                    sb.append(value.get(i));
                } else if (sentenceEndMatcher.find()) {
                    flag++;
                } else if (whiteSpaceMatcher.find() && flag != 0) {
                    sb.append("\n======================================================");
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
