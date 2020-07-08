package com.godnedy.address;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.godnedy.address.parse.AddressType;
import com.godnedy.address.parse.ParsingStrategy;
import com.godnedy.address.parse.ParsingStrategyFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class StreetAddressParser {

    private final AddressTypeFinder addressTypeFinder;
    private final ParsingStrategyFactory parsingStrategyFactory;

    public ParseAddressResponse parse(List<String> addressEntries) {
        Map<String, StreetAddress> parsedAddresses = new HashMap<>();
        addressEntries.forEach(address -> parsedAddresses.put(address, parse(address)));
        return new ParseAddressResponse(parsedAddresses);
    }


    private StreetAddress parse(String addressEntry) {
        Optional<AddressType> addressType = addressTypeFinder.findAddressType(addressEntry);
        if(!addressType.isPresent()) {
            return null;
        }
        ParsingStrategy parsingStrategy = parsingStrategyFactory.getParsingStrategy(addressType.get().getStrategyName());
        return parsingStrategy.parse(addressEntry);
    }
}
