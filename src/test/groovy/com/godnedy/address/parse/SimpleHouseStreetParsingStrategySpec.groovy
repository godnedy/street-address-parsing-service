package com.godnedy.address.parse

import spock.lang.Specification
import spock.lang.Unroll

class SimpleHouseStreetParsingStrategySpec extends Specification {

    SimpleHouseStreetParsingStrategy strategy = new SimpleHouseStreetParsingStrategy()

    @Unroll
    def "Parse  returns #houseNumber and #street for #addressEntry"() {
        when:
            def result = strategy.parse(address)
        then:
            result.street == street
            result.housenumber == houseNumber
        where:
            address                              || street          || houseNumber
            "200 Broadway Av"                    || "Broadway Av"   || "200"
            "1B HaDoa"                           || "HaDoa"         || "1B"
    }
}
