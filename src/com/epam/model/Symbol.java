package com.epam.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by Nikolai on 03.12.2015.
 */
public class Symbol implements BookComponent {
    final static String FILE_NAME = "src/textBook.txt";

    public Symbol() {
        compose();
    }

    @Override
    public ArrayList<String> getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : this.value) {
            stringBuilder.append(string + "\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public void compose() {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader (new FileReader(FILE_NAME));
            while((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line + "\n");
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        line = stringBuilder.toString().replaceAll("\\n{2,}", "\n").replaceAll("(\\s){2,}", " ");
        for (Character c : line.toCharArray()) {
            value.add(String.valueOf(c));
        }
    }
}
