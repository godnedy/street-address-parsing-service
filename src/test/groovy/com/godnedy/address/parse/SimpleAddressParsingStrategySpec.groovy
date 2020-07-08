package com.godnedy.address.parse

import spock.lang.Specification
import spock.lang.Unroll

class SimpleAddressParsingStrategySpec extends Specification {

    SimpleAddressParsingStrategy strategy = new SimpleAddressParsingStrategy()

    @Unroll
    def "Parse  returns #houseNumber and #street for #addressEntry"() {
        when:
            def result = strategy.parse(address)
        then:
            result.street == street
            result.housenumber == houseNumber
        where:
            address             || street          || houseNumber
            "Winterallee 3"     || "Winterallee"   || "3"
            "Musterstrasse 45"  || "Musterstrasse" || "45"
            "Blaufeldweg 123B"  || "Blaufeldweg"   || "123B"
            "Blaufeldweg. 123B" || "Blaufeldweg."  || "123B"
    }
}
