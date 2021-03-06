package com.epam.model;

import java.util.regex.Pattern;

/**
 * Created by Nikolai on 03.12.2015.
 */
public enum RegexPattern {
    PARAGRAPH_PATTERN       ("[А-ЯA-Z][^!.?]*[\\.\\?!]$"),
    CODE_PATTERN            (".*(/{2}.*|;|\\{|})"),
    CODE_END_PATTERN        ("[;]"),
    SENTENCE_PATTERN        ("[А-ЯA-Z]([^?!.\\(]|\\([^\\)]*\\))*[.?!]"),
    WORD_PATTERN            ("(\\d|\\s|)"),
    PUNCTUATION_PATTERN     ("\\p{Punct}"),
    WHITE_SPACE_PATTERN     ("\\s"),
    LETTER_PATTERN          ("[a-zA-Zа-яА-Я]"),
    SENTENCE_END_PATTERN    ("[\\.\\?!]"),
    SYMBOL_PATTERN          (".");

    /** A string for each pattern type */
    public Pattern name;

    /**
     * Create constructor
     * @param pattern is a ready pattern for matching
     */
    RegexPattern(String pattern) {
        this.name = Pattern.compile(pattern, Pattern.DOTALL);
    }
}
