package com.godnedy.address.parse;

import java.util.Arrays;

import com.godnedy.address.StreetAddress;
import com.godnedy.address.regex.AddressRegexComponent;
import org.apache.commons.lang3.StringUtils;


public class ComplexStreetParsingStrategy implements ParsingStrategy {

    @Override
    public StreetAddress parse(String entry) {
        String trimmed = entry.trim();
        String[] split = trimmed.split("\\s");
        int index = getIndexOfLastBeginningWithNumber(split);

        String street = StringUtils.join(Arrays.copyOfRange(split, 0, index), " ");
        String houseNumber = StringUtils.join(Arrays.copyOfRange(split, index, split.length), " ");

        return new StreetAddress(street, houseNumber);
    }

    private int getIndexOfLastBeginningWithNumber(String[] parts) {
        for (int i = parts.length - 1 ; i >= 0 ; i --) {
            if(parts[i].matches(AddressRegexComponent.HOUSE_NUMBER_WITH_LETTERS_AFTER_SPACE.getRegex())){
                return i;
            }
        }
        throw new IllegalStateException("Impossible");
    }
}
