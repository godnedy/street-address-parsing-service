package com.godnedy.address.parse;

import com.godnedy.address.StreetAddress;
import com.godnedy.address.regex.AddressRegexComponent;
import org.apache.commons.lang3.StringUtils;

class StreetNumberHouseSuffixParsingStrategy implements ParsingStrategy {

    static final String NAME = "StreetNumberHouseSuffixParsingStrategy";

    @Override
    public StreetAddress parse(String entry) {
        String trimmed = entry.trim();
        String[] split = trimmed.split(AddressRegexComponent.WHITESPACE.getRegex());
        int index = getIndexOfLastElementMatching(split, AddressRegexComponent.HOUSE_NUMBER_SUFFIX.getRegex()
                + "(" + AddressRegexComponent.HOUSE_NUMBER_WITH_LETTERS_AFTER_SPACE.getRegex() +")?");

        String street = StringUtils.join(split," ", 0, index);
        String houseNumber = StringUtils.join(split, " ", index, split.length);
        return new StreetAddress(street, houseNumber);
    }
}
