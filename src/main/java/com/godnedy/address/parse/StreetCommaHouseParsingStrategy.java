package com.godnedy.address.parse;

import com.godnedy.address.StreetAddress;
import com.godnedy.address.regex.AddressRegexComponent;

public class StreetCommaHouseParsingStrategy implements ParsingStrategy {

    @Override
    public StreetAddress parse(String entry) {
        String trimmed = entry.trim();
        String[] split = trimmed.split(AddressRegexComponent.COMMA.getRegex(), 2);
        String houseNumber = split[1].trim();
        String street = split[0].trim();
        return new StreetAddress(street, houseNumber);
    }
}
