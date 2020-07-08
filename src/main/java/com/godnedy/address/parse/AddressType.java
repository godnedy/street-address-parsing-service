package com.godnedy.address.parse;

import lombok.Getter;

@Getter
public enum AddressType {
    SIMPLE(SimpleAddressParsingStrategy.NAME),
    COMPLEX_STREET(ComplexStreetParsingStrategy.NAME),
    HOUSE_COMMA_STREET(HouseCommaStreetParsingStrategy.NAME),
    STREET_COMMA_HOUSE(StreetCommaHouseParsingStrategy.NAME),
    SIMPLE_HOUSE_STREET(SimpleHouseStreetParsingStrategy.NAME),
    STREET_HOUSE_NUMBER_SUFFIX(StreetNumberHouseSuffixParsingStrategy.NAME),
    STREET_COMMA_HOUSE_NUMBER_SUFFIX(StreetCommaHouseParsingStrategy.NAME),
    STREET_NUMBER_HOUSE_NUMBER_SUFFIX(StreetNumberHouseSuffixParsingStrategy.NAME);

    private final String strategyName;

    AddressType(String strategyName){
        this.strategyName = strategyName;
    }
}
