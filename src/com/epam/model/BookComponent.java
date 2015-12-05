package com.epam.model;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by Nikolai on 03.12.2015.
 */
public interface BookComponent {

    Pattern pattern = RegexPattern.PARAGRAPH_PATTERN.name;
    Pattern sentencePattern = RegexPattern.SENTENCE_PATTERN.name;
    Pattern sentenceEndPattern = RegexPattern.SENTENCE_END_PATTERN.name;
    Pattern letterPattern = RegexPattern.LETTER_PATTERN.name;
    Pattern punctuationPattern = RegexPattern.PUNCTUATION_PATTERN.name;
    Pattern whiteSpacePattern = RegexPattern.WHITE_SPACE_PATTERN.name;
    Pattern symbolPattern = RegexPattern.SYMBOL_PATTERN.name;
    ArrayList<String> value = new ArrayList<String>();

    String toString();
    ArrayList<String> getValue();
    void compose();

}
