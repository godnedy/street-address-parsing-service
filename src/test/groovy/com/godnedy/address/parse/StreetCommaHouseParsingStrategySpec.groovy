package com.godnedy.address.parse

import spock.lang.Specification
import spock.lang.Unroll


class StreetCommaHouseParsingStrategySpec extends Specification {

    StreetCommaHouseParsingStrategy strategy = new StreetCommaHouseParsingStrategy()

    @Unroll
    def "Parse  returns #houseNumber and #street for #addressEntry"() {
        when:
            def result = strategy.parse(address)
        then:
            result.street == street
            result.housenumber == houseNumber
        where:
            address                   || street                         || houseNumber
            "Calle Aduana, 29"        || "Calle Aduana"                 || "29"
            "Way 2259, 2919"          || "Way 2259"                     || "2919"

            "vul. Centraĺnaja, d. 20"             || "vul. Centraĺnaja"             || "d. 20"
            "str. Pacienței, nr. 9"               || "str. Pacienței"               || "nr. 9"
            "vul. Shevchenka, bud. 17"            || "vul. Shevchenka"              || "bud. 17"
    }
}
