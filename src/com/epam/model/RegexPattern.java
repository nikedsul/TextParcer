package com.epam.model;

import java.util.regex.Pattern;

/**
 * Created by Nikolai on 03.12.2015.
 */
public enum RegexPattern {
    PARAGRAPH_PATTERN   ("^[^(\\.)(.*(/{2}.*|;|\\\\{|}))]*"),
    CODE_PATTERN        (".*(/{2}.*|;|\\{|})"),
    SENTENCE_PATTERN    ("[^\\.]+(\\. )"),
    WORD_PATTERN        ("(\\d|\\s|(\\p{Punct}))"),
    SYMBOL_PATTERN        (".");

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
