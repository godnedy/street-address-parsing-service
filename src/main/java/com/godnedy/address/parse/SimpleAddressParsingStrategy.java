package com.godnedy.address.parse;

import com.godnedy.address.StreetAddress;
import com.godnedy.address.regex.AddressRegexComponent;

public class SimpleAddressParsingStrategy implements ParsingStrategy {

    @Override
    public StreetAddress parse(String entry) {
        String trimmed = entry.trim();
        String[] split = (trimmed.split(AddressRegexComponent.WHITESPACE.getRegex()));
        return new StreetAddress(split[0], split[1]);
    }
}
