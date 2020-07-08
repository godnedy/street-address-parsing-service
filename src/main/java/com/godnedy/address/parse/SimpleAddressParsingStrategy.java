package com.godnedy.address.parse;

import com.godnedy.address.StreetAddress;
import com.godnedy.address.regex.AddressRegexComponent;

class SimpleAddressParsingStrategy implements ParsingStrategy {

    static final String NAME = "SimpleAddressParsingStrategy";

    @Override
    public StreetAddress parse(String entry) {
        String trimmed = entry.trim();
        String[] split = trimmed.split(AddressRegexComponent.WHITESPACE.getRegex());

        String street = split[0];
        String houseNumber = split[1];
        return new StreetAddress(street, houseNumber);
    }
}
