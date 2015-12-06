package com.epam.view;

import com.epam.model.*;

/**
 * Created by Nikolai on 03.12.2015.
 */
public class Main {

    public static void main(String[] args) {
        TextParser text = new TextParser("src/textBook.txt");
        BookComponent paragraph = new Paragraph();
        System.out.println(paragraph.getComponents());
    }
}
