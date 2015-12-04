package com.epam.view;

import com.epam.model.Paragraph;
import com.epam.model.Sentence;
import com.epam.model.Symbol;
import com.epam.model.Word;

import java.util.regex.Pattern;

/**
 * Created by Nikolai on 03.12.2015.
 */
public class Main {

    public static void main(String[] args) {
        Symbol symbol = new Symbol();
        Word word = new Word();
        Sentence sentence = new Sentence();
        Paragraph paragraph = new Paragraph();
        System.out.println(word.toString());
    }
}
