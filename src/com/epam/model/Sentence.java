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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbFinal = new StringBuilder();
        String line = "";
        int flag = 0;
        if (value.size() > 0) {
            for (int i = 0; i < value.size(); i++) {
                Matcher sentenceEndMatcher = sentenceEndPattern.matcher(value.get(i));
                Matcher whiteSpaceMatcher = whiteSpacePattern.matcher(value.get(i));
                sb.append(value.get(i));
                if (sentenceEndMatcher.find()) {
                    flag++;
                } else if (whiteSpaceMatcher.find() && flag != 0 && value.get(i-1).matches("((\\.)|(\\?)|!)")) {
                    line = sb.toString();
                    sb.append("\n");
                    flag = 0;
                }
            }
            if (line.length() > 0) {
                Matcher sentenceMatcher = sentencePattern.matcher(line);
                if (sentenceMatcher.find()){
                    sbFinal.append(line);
                    line = "";
                    sb.delete(0, Integer.MAX_VALUE);
                }
            }
        } else {
            return "No symbols have been found!";
        }
        return sbFinal.toString();
    }
}
