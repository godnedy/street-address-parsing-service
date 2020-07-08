package com.godnedy.address;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

import com.godnedy.address.regex.AddressRegexComponent;
import org.springframework.stereotype.Component;


@Component
class AddressTypeFinder {

    private static final HashMap<String, AddressType> regexToAddressType = new LinkedHashMap<>();

    private static final String SIMPLE_REGEX = AddressRegexComponent.SINGLE_WORD_STREET.getRegex()
            + AddressRegexComponent.WHITESPACE.getRegex()
            + AddressRegexComponent.HOUSE_NUMBER.getRegex();

    private static final String COMPLEX_STREET_SIMPLE_HOUSE_NUMBER_REGEX = AddressRegexComponent.MULTIPLE_WORD_STREET.getRegex()
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

    private static final String NUMBER_STREET_REGEX = AddressRegexComponent.HOUSE_NUMBER.getRegex()
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
        regexToAddressType.put(SIMPLE_REGEX, AddressType.SIMPLE);
        regexToAddressType.put(STREET_NUMBER_HOUSE_NUMBER_SUFFIX, AddressType.STREET_NUMBER_HOUSE_NUMBER_SUFFIX);

        regexToAddressType.put(STREET_HOUSE_NUMBER_SUFFIX, AddressType.STREET_HOUSE_NUMBER_SUFFIX);
        regexToAddressType.put(STREET_COMMA_HOUSE_NUMBER_SUFFIX, AddressType.STREET_COMMA_HOUSE_NUMBER_SUFFIX);

        regexToAddressType.put(COMPLEX_STREET_SIMPLE_HOUSE_NUMBER_REGEX, AddressType.COMPLEX_STREET);  //TODO those two merge?
        regexToAddressType.put(COMPLEX_STREET_COMPLEX_HOUSE_NUMBER_REGEX, AddressType.COMPLEX_STREET);
        regexToAddressType.put(STREET_COMMA_NUMBER_REGEX, AddressType.STREET_COMMA_HOUSE);
        regexToAddressType.put(NUMBER_COMMA_STREET_REGEX, AddressType.HOUSE_COMMA_STREET);
        regexToAddressType.put(NUMBER_STREET_REGEX, AddressType.HOUSE_STREET);

    };

    public AddressType findAddressType(String streetAddress) {

        return regexToAddressType.entrySet().stream()
                .filter(regex -> matches(regex.getKey(), streetAddress))
                .map(Map.Entry::getValue)
                .findFirst()
                .orElse(AddressType.UNKNOWN);
    }

    private boolean matches(String regex, String streetAddress) {
        return Pattern.compile(regex)
                .matcher(streetAddress)
                .matches();
    }
}
