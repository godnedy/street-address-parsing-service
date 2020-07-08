package com.godnedy.address.parse

import spock.lang.Specification
import spock.lang.Unroll

class HouseCommaStreetParsingStrategySpec extends Specification {

    HouseCommaStreetParsingStrategy strategy = new HouseCommaStreetParsingStrategy()

    @Unroll
    def "Parse  returns #houseNumber and #street for #addressEntry"() {
        when:
            def result = strategy.parse(address)
        then:
            result.street == street
            result.housenumber == houseNumber
        where:
            address                               || street                         || houseNumber
            "4, rue de la revolution"             || "rue de la revolution"         || "4"
            "101–3485, rue de la Montagne"        || "rue de la Montagne"           || "101–3485"
            "15, M. A. Jinnah Road"               || "M. A. Jinnah Road"            || "15"
    }
}
