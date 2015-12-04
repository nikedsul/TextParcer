package com.epam.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nikolai on 03.12.2015.
 */
public class Paragraph extends Sentence {

    private static Pattern pattern = RegexPattern.PARAGRAPH_PATTERN.name;

    public Paragraph(BookComponent component) {
        super(component);

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
            for (String component : value) {
                sb.append(component);
            }
        } else {
            return "No sentences have been found!";
        }
        return sb.toString();
    }

    @Override
    public void compose() {
        Matcher matcher = pattern.matcher(this.toString());
        while (matcher.find()) {
            value.add(matcher.group());
        }
    }
}
