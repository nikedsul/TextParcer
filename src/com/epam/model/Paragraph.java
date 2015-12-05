package com.epam.model;

import java.util.regex.Matcher;

/**
 * Created by Nikolai on 03.12.2015.
 */
public class Paragraph extends Sentence {

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbFinal = new StringBuilder();
        int flag = 0;
        if (value.size() > 0) {
            for (int i = 0; i < value.size(); i++) {
                sb.append(value.get(i));

                if (value.get(i).equals("\n")) {
                    Matcher paragraphMatcher = paragraphPattern.matcher(sb.toString());
                    if (paragraphMatcher.find()) {
                        sbFinal.append(sb.toString().trim() + "\n");
                    }
                    sb.delete(0, Integer.MAX_VALUE);
                }
            }
        } else {
            return "No sentences have been found!";
        }
        return sbFinal.toString();
    }
}
