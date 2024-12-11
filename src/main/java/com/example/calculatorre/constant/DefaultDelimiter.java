package com.example.calculatorre.constant;

public enum DefaultDelimiter {
    COMMA(','),
    COLON(':');

    private final char delimiter;

    DefaultDelimiter(char delimiter) {
        this.delimiter = delimiter;
    }

    public char getDelimiter() {
        return delimiter;
    }

}
