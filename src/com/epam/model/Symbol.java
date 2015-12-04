package com.epam.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
        for (String string : value) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    @Override
    public void compose() {
        List<String> list = new ArrayList<String>();
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader (new FileReader(FILE_NAME));
            while((line = bufferedReader.readLine()) != null){
                stringBuilder.append(line);
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        for (Character c : stringBuilder.toString().toCharArray()) {
            value.add(String.valueOf(c));
        }
    }
}
