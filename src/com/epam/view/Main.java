package com.epam.view;

import com.epam.model.*;

import java.util.regex.Pattern;

/**
 * Created by Nikolai on 03.12.2015.
 */
public class Main {

    public static void main(String[] args) {
        BookComponent symbol = new Symbol();
        BookComponent word = new Word();
        Word sentence = new Sentence();
        BookComponent paragraph = new Paragraph();
        System.out.println(word.toString());
    }
}
