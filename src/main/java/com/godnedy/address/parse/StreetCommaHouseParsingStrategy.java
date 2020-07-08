package com.godnedy.address.parse;

import com.godnedy.address.StreetAddress;
import com.godnedy.address.regex.AddressRegexComponent;

class StreetCommaHouseParsingStrategy implements ParsingStrategy {

    static final String NAME = "StreetCommaHouseParsingStrategy";

    @Override
    public StreetAddress parse(String entry) {
        String trimmed = entry.trim();
        String[] split = trimmed.split(AddressRegexComponent.COMMA.getRegex(), 2);

        String street = split[0].trim();
        String houseNumber = split[1].trim();
        return new StreetAddress(street, houseNumber);
    }
}
