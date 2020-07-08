package com.godnedy.address;

import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import com.godnedy.address.parse.AddressType;
import org.springframework.stereotype.Component;

import static com.godnedy.address.regex.AddressRegex.ADDRESS_TYPE_MAP;


@Component
class AddressTypeFinder {

    public Optional<AddressType> findAddressType(String streetAddress) {
        return ADDRESS_TYPE_MAP.entrySet().stream()
                .filter(regex -> matches(regex.getKey(), streetAddress))
                .map(Map.Entry::getValue)
                .findFirst();
    }

    private boolean matches(String regex, String streetAddress) {
        return Pattern.compile(regex)
                .matcher(streetAddress)
                .matches();
    }
}
