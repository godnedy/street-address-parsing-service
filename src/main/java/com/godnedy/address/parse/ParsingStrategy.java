package com.godnedy.address.parse;

import com.godnedy.address.StreetAddress;

public interface ParsingStrategy {
    
    StreetAddress parse(String entry);
}
