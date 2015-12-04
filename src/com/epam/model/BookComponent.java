package com.epam.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Created by Nikolai on 03.12.2015.
 */
public interface BookComponent {
    Pattern pattern = null;
    ArrayList<String> value = new ArrayList<String>();

    String toString();
    ArrayList<String> getValue();
    void compose();

}
