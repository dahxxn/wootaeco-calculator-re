package com.example.calculatorre.constant;

public enum Regex {
    NUMBER_REGEX("([1-9])+([0-9])*"),
    CUSTOM_FORMAT_REGEX("^(//)(.)(\\\\n)");

    private final String regex;

    Regex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
