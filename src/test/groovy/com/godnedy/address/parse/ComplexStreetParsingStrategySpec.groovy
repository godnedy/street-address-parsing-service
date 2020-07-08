package com.godnedy.address.parse

import spock.lang.Specification
import spock.lang.Unroll

class ComplexStreetParsingStrategySpec extends Specification {

    ComplexStreetParsingStrategy strategy = new ComplexStreetParsingStrategy();

    @Unroll
    def "Parse  returns #houseNumber and #street for #addressEntry"() {
        when:
            def result = strategy.parse(address)
        then:
            result.street == street
            result.housenumber == houseNumber
        where:
            address                               || street                         || houseNumber
            "Auf der Vogelwiese 23 b"             || "Auf der Vogelwiese"           || "23 b"
            "Slovenska cesta 64 A"                || "Slovenska cesta"              || "64 A"
            "Am Bächle 23"                        || "Am Bächle"                    || "23"
            "Jelgavas iela 1–12"                  || "Jelgavas iela"                || "1–12"
            "ul. 3 Maja 1-12"                     || "ul. 3 Maja"                   || "1-12"
    }
}
