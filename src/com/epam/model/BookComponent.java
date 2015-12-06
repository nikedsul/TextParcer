package com.epam.model;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by Nikolai on 03.12.2015.
 */
public interface BookComponent {

    /* Patterns to match text parts */
    Pattern paragraphPattern = RegexPattern.PARAGRAPH_PATTERN.name;
    Pattern sentencePattern = RegexPattern.SENTENCE_PATTERN.name;
    Pattern sentenceEndPattern = RegexPattern.SENTENCE_END_PATTERN.name;
    Pattern letterPattern = RegexPattern.LETTER_PATTERN.name;
    Pattern codePattern = RegexPattern.CODE_PATTERN.name;
    Pattern codeEndPattern = RegexPattern.CODE_END_PATTERN.name;
    Pattern whiteSpacePattern = RegexPattern.WHITE_SPACE_PATTERN.name;

    /** WHOLE_TEXT list contains the entire text */
    ArrayList<String> WHOLE_TEXT = new ArrayList<>();

    /**
     * Method toStringAll returns the string of components
     * @return
     */
    String toStringAll();

    /**
     * Method toStringOne returns a single component by it's ordinal number
     * @param componentOrdinal ordinal number of the component in list
     * @return
     */
    String toStringOne(int componentOrdinal);

    /**
     * Method getComponents returns a list of components
     * @return
     */
    ArrayList<String> getComponents();

    /**
     * Method makeList creates a list of specified components
     */
    void makeList();

}
