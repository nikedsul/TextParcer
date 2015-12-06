package com.epam.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Class TextParser parses a text from a given file and creates a whole list of every single symbol of the text
 * Created by Nikolai on 03.12.2015.
 */
public class TextParser implements BookComponent {
    private static String fileName;

    /**
     * Constructor
     * @param fileName is a name of a file to parse
     */
    public TextParser(String fileName) {
        this.fileName = fileName;
        makeList();
    }

    @Override
    public ArrayList<String> getComponents() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toStringAll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toStringOne(int componentOrdinal) {
        return null;
    }

    @Override
    public void makeList() {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader (new FileReader(fileName));
            while((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line).append("\n");
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        line = stringBuilder.toString().replaceAll("\\n{2,}", "\n").replaceAll("(\\s){2,}", " ");
        for (Character c : line.toCharArray()) {
            WHOLE_TEXT.add(String.valueOf(c));
        }
    }
}
