package com.godnedy.address;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class ParseAddressResponse {

    Map<String, StreetAddress> parsedAddresses;
}
