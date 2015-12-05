package com.epam.model;

import java.util.regex.Pattern;

/**
 * Created by Nikolai on 03.12.2015.
 */
public enum RegexPattern {
    PARAGRAPH_PATTERN       ("^[^(\\.)(.*(/{2}.*|;|\\\\{|}))]*"),
    CODE_PATTERN            (".*(/{2}.*|;|\\{|})"),
    SENTENCE_PATTERN        ("[^((\\.)|(\\?)|!)]+(\\. )"),
    WORD_PATTERN            ("(\\d|\\s|)"),
    PUNCTUATION_PATTERN     ("\\p{Punct}"),
    WHITE_SPACE_PATTERN     ("\\s"),
    LETTER_PATTERN          ("[a-zA-Zа-яА-Я]"),
    SENTENCE_END_PATTERN    ("((\\.)|(\\?)|!)"),
    SENTENCE_START_PATTERN  ("[($\\s*)()]"),
    SYMBOL_PATTERN          (".");

    /** A string for each pattern type */
    public Pattern name;

    /**
     * Create constructor
     * @param pattern
     */
    RegexPattern(String pattern) {
        this.name = Pattern.compile(pattern, Pattern.DOTALL);
    }
}
