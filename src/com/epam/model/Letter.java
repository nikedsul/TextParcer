package com.epam.model;

import java.util.ArrayList;

/**
 * Created by Nikolai on 03.12.2015.
 */
public class Letter implements BookComponent {
    static ArrayList<String> symbols = new ArrayList<>();

    public Letter() {
        makeList();
    }

    @Override
    public ArrayList<String> getComponents() {
        return symbols;
    }

    @Override
    public String toStringAll() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : symbols) {
            stringBuilder.append(string + "\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String toStringOne(int componentOrdinal) {
        if ((symbols.size() - 1) < componentOrdinal) {
            return "There are only " + symbols.size() + " components in the list!";
        }
        return WHOLE_TEXT.get(componentOrdinal);
    }

    @Override
    public void makeList() {
        for (String string : WHOLE_TEXT) {
            symbols.add(string);
        }
    }
}
