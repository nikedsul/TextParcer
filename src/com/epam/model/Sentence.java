package com.epam.model;

import java.util.regex.Matcher;

/**
 * Created by Nikolai on 03.12.2015.
 */
public class Sentence extends Word {

    public Sentence() {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbFinal = new StringBuilder();
        int flag = 0;
        if (value.size() > 0) {
            for (int i = 0; i < value.size(); i++) {
                Matcher sentenceEndMatcher = sentenceEndPattern.matcher(value.get(i));
                Matcher whiteSpaceMatcher = whiteSpacePattern.matcher(value.get(i));
                sb.append(value.get(i));
                if (flag != 0 && !whiteSpaceMatcher.find()) {
                    flag = 0;
                } else if (sentenceEndMatcher.find() || value.get(i).equals("\n")) {
                    flag++;
                } else if ((sentenceEndMatcher.find() || value.get(i).equals("\n")) && flag != 0) {
                    flag = 0;
                }
                if (flag != 0 && whiteSpaceMatcher.find()) {
                    Matcher sentenceMatcher = sentencePattern.matcher(sb.toString());
                    if (sentenceMatcher.find()) {
                        sbFinal.append(sb.toString() + "\n");
                    }
                    sb.delete(0, Integer.MAX_VALUE);
                    flag = 0;
                }
            }
        } else {
            return "No sentences have been found!";
        }
        return sbFinal.toString();
    }
}
