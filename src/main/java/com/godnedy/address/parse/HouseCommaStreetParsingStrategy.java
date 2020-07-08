package com.godnedy.address.parse;

import com.godnedy.address.StreetAddress;
import com.godnedy.address.regex.AddressRegexComponent;

public class HouseCommaStreetParsingStrategy implements ParsingStrategy {

    @Override
    public StreetAddress parse(String entry) {
        String trimmed = entry.trim();
        String[] split = trimmed.split(AddressRegexComponent.COMMA.getRegex(), 2);
        String houseNumber = split[0].trim();
        String street = split[1].trim();
        return new StreetAddress(street, houseNumber);
    }
}
