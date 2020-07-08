package com.godnedy.address.regex;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.godnedy.address.parse.AddressType;

public class AddressRegex {

    public static final HashMap<String, AddressType> ADDRESS_TYPE_MAP = new LinkedHashMap<>();

    private static final String SIMPLE_REGEX = AddressRegexComponent.SINGLE_WORD_STREET.getRegex()
            + AddressRegexComponent.WHITESPACE.getRegex()
            + AddressRegexComponent.HOUSE_NUMBER.getRegex();


    private static final String COMPLEX_STREET_COMPLEX_HOUSE_NUMBER_REGEX = AddressRegexComponent.MULTIPLE_WORD_STREET.getRegex()
            + AddressRegexComponent.WHITESPACE.getRegex()
            + AddressRegexComponent.HOUSE_NUMBER_WITH_LETTERS_AFTER_SPACE.getRegex();

    private static final String NUMBER_COMMA_STREET_REGEX = AddressRegexComponent.HOUSE_NUMBER_WITH_LETTERS_AFTER_SPACE.getRegex()
            + AddressRegexComponent.COMMA.getRegex()
            + AddressRegexComponent.WHITESPACE.getRegex()
            + AddressRegexComponent.MULTIPLE_WORD_STREET.getRegex();

    private static final String STREET_COMMA_NUMBER_REGEX = AddressRegexComponent.MULTIPLE_WORD_STREET.getRegex()
            + AddressRegexComponent.COMMA.getRegex()
            + AddressRegexComponent.WHITESPACE.getRegex()
            + AddressRegexComponent.HOUSE_NUMBER_WITH_LETTERS_AFTER_SPACE.getRegex();

    private static final String SIMPLE_HOUSE_STREET_REGEX = AddressRegexComponent.HOUSE_NUMBER.getRegex()
            + AddressRegexComponent.WHITESPACE.getRegex()
            + AddressRegexComponent.MULTIPLE_WORD_STREET.getRegex();

    private static final String STREET_HOUSE_NUMBER_SUFFIX = AddressRegexComponent.MULTIPLE_WORD_STREET.getRegex()
            + AddressRegexComponent.WHITESPACE.getRegex()
            + AddressRegexComponent.HOUSE_NUMBER_SUFFIX.getRegex()
            + AddressRegexComponent.HOUSE_NUMBER_WITH_LETTERS_AFTER_SPACE.getRegex();

    private static final String STREET_COMMA_HOUSE_NUMBER_SUFFIX = AddressRegexComponent.MULTIPLE_WORD_STREET.getRegex()
            + AddressRegexComponent.COMMA.getRegex()
            + AddressRegexComponent.WHITESPACE.getRegex()
            + AddressRegexComponent.HOUSE_NUMBER_SUFFIX.getRegex()
            + AddressRegexComponent.HOUSE_NUMBER_WITH_LETTERS_AFTER_SPACE.getRegex();

    private static final String STREET_NUMBER_HOUSE_NUMBER_SUFFIX = AddressRegexComponent.SINGLE_WORD_STREET.getRegex()
            + AddressRegexComponent.WHITESPACE.getRegex()
            + AddressRegexComponent.HOUSE_NUMBER.getRegex()
            + AddressRegexComponent.WHITESPACE.getRegex()
            + AddressRegexComponent.HOUSE_NUMBER_SUFFIX.getRegex()
            + AddressRegexComponent.HOUSE_NUMBER_WITH_LETTERS_AFTER_SPACE.getRegex();

    static {
        ADDRESS_TYPE_MAP.put(SIMPLE_REGEX, AddressType.SIMPLE);
        ADDRESS_TYPE_MAP.put(STREET_COMMA_NUMBER_REGEX, AddressType.STREET_COMMA_HOUSE);
        ADDRESS_TYPE_MAP.put(NUMBER_COMMA_STREET_REGEX, AddressType.HOUSE_COMMA_STREET);
        ADDRESS_TYPE_MAP.put(STREET_NUMBER_HOUSE_NUMBER_SUFFIX, AddressType.STREET_NUMBER_HOUSE_NUMBER_SUFFIX);

        ADDRESS_TYPE_MAP.put(STREET_HOUSE_NUMBER_SUFFIX, AddressType.STREET_HOUSE_NUMBER_SUFFIX);
        ADDRESS_TYPE_MAP.put(STREET_COMMA_HOUSE_NUMBER_SUFFIX, AddressType.STREET_COMMA_HOUSE_NUMBER_SUFFIX);
        ADDRESS_TYPE_MAP.put(COMPLEX_STREET_COMPLEX_HOUSE_NUMBER_REGEX, AddressType.COMPLEX_STREET);
        ADDRESS_TYPE_MAP.put(SIMPLE_HOUSE_STREET_REGEX, AddressType.SIMPLE_HOUSE_STREET);

    }

}
