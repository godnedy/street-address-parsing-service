package com.godnedy.address.regex;

public enum AddressRegexComponent {

    HOUSE_NUMBER("\\d+\\S*"),
    HOUSE_NUMBER_WITH_LETTERS_AFTER_SPACE("\\d+\\s*\\S*\\-*\\d*\\s*\\S*"),
    SINGLE_WORD_STREET("\\p{L}+\\.*"),
    MULTIPLE_WORD_STREET("([\\p{L}|\\d]+\\.*)(\\s[\\p{L}|\\d]+\\.*)*"),
    WHITESPACE("\\s"),
    COMMA (","),
    HOUSE_NUMBER_SUFFIX("(d\\.|#|No|útja|No\\.|nr\\.|No\\:|bud\\.)\\s*");


    private final String regex;

    AddressRegexComponent(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}

