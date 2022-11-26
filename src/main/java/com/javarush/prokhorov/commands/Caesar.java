package com.javarush.prokhorov.commands;

import static com.javarush.prokhorov.constants.Strings.ALPHABET;

public class Caesar {
    private Caesar() {
    }

    public static char symbol_right_shift(char text, int shift) {
    if (ALPHABET.indexOf(text) != -1) {
        return ALPHABET.charAt((ALPHABET.indexOf(text) + shift) % ALPHABET.length());
    } else {
        return text;
    }

}

    public static char symbol_left_shift(char text, int shift) {
        if (ALPHABET.indexOf(text) != -1) {
            int result = ALPHABET.length() - shift;
            return ALPHABET.charAt((ALPHABET.indexOf(text) + result) % ALPHABET.length());
        } else {
            return text;
        }
    }

}
