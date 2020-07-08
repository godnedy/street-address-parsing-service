package com.godnedy.address

import spock.lang.Specification
import spock.lang.Unroll

import static com.godnedy.address.AddressType.*

class AddressTypeFinderSpec extends Specification {

    AddressTypeFinder finder = new AddressTypeFinder()

    @Unroll
    def "FindAddressType returns #addressType for address = #address"() {
        when:
            def result = finder.findAddressType(address)
        then:
            result == addressType
        where:
            address                               || addressType
            "Winterallee 3"                       || SIMPLE
            "Musterstrasse 45"                    || SIMPLE
            "Blaufeldweg 123B"                    || SIMPLE
            "Blaufeldweg. 123B"                   || SIMPLE

            "Auf der Vogelwiese 23 b"             || COMPLEX_STREET
            "Slovenska cesta 64 A"                || COMPLEX_STREET
            "Am Bächle 23"                        || COMPLEX_STREET
            "Jelgavas iela 1–12"                  || COMPLEX_STREET
            "ul. 3 Maja 1–12"                       || COMPLEX_STREET

            "4, rue de la revolution"             || HOUSE_COMMA_STREET
            "101–3485, rue de la Montagne"        || HOUSE_COMMA_STREET
            "15, M. A. Jinnah Road"               || HOUSE_COMMA_STREET
            "Calle Aduana, 29"                    || STREET_COMMA_HOUSE
            "Way 2259, 2919"                      || STREET_COMMA_HOUSE

            "200 Broadway Av"                     || HOUSE_STREET
            "1B HaDoa"                            || HOUSE_STREET

            "Calle 39 No 1540"                    || STREET_NUMBER_HOUSE_NUMBER_SUFFIX
            "Calle 34 #24-30"                     || STREET_NUMBER_HOUSE_NUMBER_SUFFIX

            "vul. Centraĺnaja, d. 20"             || STREET_COMMA_HOUSE_NUMBER_SUFFIX
            "str. Pacienței, nr. 9"               || STREET_COMMA_HOUSE_NUMBER_SUFFIX
            "vul. Shevchenka, bud. 17"            || STREET_COMMA_HOUSE_NUMBER_SUFFIX

            "Jalan Medan Merdeka Selatan No. 8-9" || STREET_HOUSE_NUMBER_SUFFIX
            "C. Francisco I. Madero No. 115"      || STREET_HOUSE_NUMBER_SUFFIX
            "vÁrpád fejedelem útja 82."           || STREET_HOUSE_NUMBER_SUFFIX
            "Badem Sk. No:13"                     || STREET_HOUSE_NUMBER_SUFFIX


    }
}
