package com.epam.view;

import com.epam.model.*;

/**
 * Created by Nikolai on 03.12.2015.
 */
public class Main {

    public static void main(String[] args) {
        BookComponent text = new TextParser("src/textBook.txt");
        BookComponent letter = new Letter();
        BookComponent word = new Word();
        BookComponent sentence = new Sentence();
        BookComponent paragraph = new Paragraph();
        BookComponent code = new Code();
        System.out.println(code.toStringAll());
    }
}
