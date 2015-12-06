package com.epam.model;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by Nikolai on 03.12.2015.
 */
public interface BookComponent {

    Pattern paragraphPattern = RegexPattern.PARAGRAPH_PATTERN.name;
    Pattern sentencePattern = RegexPattern.SENTENCE_PATTERN.name;
    Pattern sentenceEndPattern = RegexPattern.SENTENCE_END_PATTERN.name;
    Pattern letterPattern = RegexPattern.LETTER_PATTERN.name;
    Pattern codePattern = RegexPattern.CODE_PATTERN.name;
    Pattern codeEndPattern = RegexPattern.CODE_END_PATTERN.name;
    Pattern whiteSpacePattern = RegexPattern.WHITE_SPACE_PATTERN.name;
    Pattern symbolPattern = RegexPattern.SYMBOL_PATTERN.name;
    
    ArrayList<String> WHOLE_TEXT = new ArrayList<>();

    String toStringAll();
    String toStringOne(int componentOrdinal);
    ArrayList<String> getComponents();
    void makeList();

}
