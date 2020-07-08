package com.godnedy.address.parse;

import com.godnedy.address.StreetAddress;
import com.godnedy.address.regex.AddressRegexComponent;

class SimpleHouseStreetParsingStrategy implements ParsingStrategy {

    static final String NAME = "SimpleHouseStreetParsingStrategy";

    @Override
    public StreetAddress parse(String entry) {
        String trimmed = entry.trim();
        String[] split = (trimmed.split(AddressRegexComponent.WHITESPACE.getRegex(), 2));

        String street = split[1];
        String houseNumber = split[0];
        return new StreetAddress(street, houseNumber);

    }
}
