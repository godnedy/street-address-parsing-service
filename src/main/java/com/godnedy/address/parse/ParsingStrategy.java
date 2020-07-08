package com.godnedy.address.parse;

import com.godnedy.address.StreetAddress;

public interface ParsingStrategy {
    
    StreetAddress parse(String entry);

    default int getIndexOfLastElementMatching(String[] elements, String regex) {
        for (int i = elements.length - 1 ; i >= 0 ; i --) {
            if(elements[i].matches(regex)){
                return i;
            }
        }
        throw new IllegalStateException("Something went wrong");
    }
}
