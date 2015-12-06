package com.epam.model;

import java.util.ArrayList;
import java.util.regex.Matcher;

/**
 * Created by Nikolai on 06.12.2015.
 */
public class Code implements BookComponent {
    static ArrayList<String> codes = new ArrayList<>();

    public Code() {
        makeList();
    }

    @Override
    public ArrayList<String> getComponents() {
        return codes;
    }

    @Override
    public String toStringAll() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : codes) {
            stringBuilder.append(string + "\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toStringOne(int componentOrdinal) {
        if ((codes.size() - 1) < componentOrdinal) {
            return "There are only " + codes.size() + " components in the list!";
        }
        return WHOLE_TEXT.get(componentOrdinal);
    }

    @Override
    public void makeList() {
        StringBuilder sb = new StringBuilder();
        int flag = 0;
        if (WHOLE_TEXT.size() > 0) {
            for (int i = 0; i < WHOLE_TEXT.size(); i++) {
                Matcher whiteSpaceMatcher = whiteSpacePattern.matcher(WHOLE_TEXT.get(i));
                Matcher codeEndMatcher = codeEndPattern.matcher(WHOLE_TEXT.get(i));
                sb.append(WHOLE_TEXT.get(i));

                if (codeEndMatcher.find() || WHOLE_TEXT.get(i).equals("\n")) {
                    flag++;
                }

                if (flag != 0 && whiteSpaceMatcher.find()) {
                    Matcher codeMatcher = codePattern.matcher(sb.toString());
                    if (codeMatcher.find()) {
                        codes.add(sb.toString().trim());
                    }
                    sb.delete(0, Integer.MAX_VALUE);
                    flag = 0;
                }
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }
}
