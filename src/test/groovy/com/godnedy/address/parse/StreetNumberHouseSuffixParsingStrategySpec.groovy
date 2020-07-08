package com.godnedy.address.parse

import spock.lang.Specification
import spock.lang.Unroll

class StreetNumberHouseSuffixParsingStrategySpec extends Specification {

    StreetNumberHouseSuffixParsingStrategy strategy = new StreetNumberHouseSuffixParsingStrategy()

    @Unroll
    def "Parse  returns #houseNumber and #street for #addressEntry"() {
        when:
            def result = strategy.parse(address)
        then:
            result.street == street
            result.housenumber == houseNumber
        where:
            address                               || street                         || houseNumber
            "Calle 39 No 1540"                    || "Calle 39"                     || "No 1540"
            "Calle 34 #24-30"                     || "Calle 34"                     || "#24-30"

            "Jalan Medan Merdeka Selatan No. 8-9" || "Jalan Medan Merdeka Selatan"  || "No. 8-9"
            "C. Francisco I. Madero No. 115"      || "C. Francisco I. Madero"       || "No. 115"
            "vÁrpád fejedelem útja 82."           || "vÁrpád fejedelem"             || "útja 82."
            "Badem Sk. No:13"                     || "Badem Sk."                    || "No:13"
    }
}
