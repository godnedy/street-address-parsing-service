package com.godnedy.address

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification
import spock.lang.Unroll

@SpringBootTest
class StreetAddressParserIntegrationSpec extends Specification {

    @Autowired
    StreetAddressParser parser

    @Unroll
    def "Parse returns #houseNumber and #street for #addressEntry"() {
        given:
            def entries = Collections.singletonList(address)
        when:
            def result = parser.parse(entries)
        then:
            result.getParsedAddresses().get(address).street == street
            result.getParsedAddresses().get(address).housenumber == houseNumber
        where:
            address                               || street                        || houseNumber
            "Winterallee 3"                       || "Winterallee"                 || "3"
            "Musterstrasse 45"                    || "Musterstrasse"               || "45"
            "Blaufeldweg 123B"                    || "Blaufeldweg"                 || "123B"
            "Blaufeldweg. 123B"                   || "Blaufeldweg."                || "123B"

            "Auf der Vogelwiese 23 b"             || "Auf der Vogelwiese"          || "23 b"
            "Slovenska cesta 64 A"                || "Slovenska cesta"             || "64 A"
            "Am Bächle 23"                        || "Am Bächle"                   || "23"
            "Jelgavas iela 1–12"                  || "Jelgavas iela"               || "1–12"
            "ul. 3 Maja 1-12"                     || "ul. 3 Maja"                  || "1-12"

            "4, rue de la revolution"             || "rue de la revolution"        || "4"
            "101–3485, rue de la Montagne"        || "rue de la Montagne"          || "101–3485"
            "15, M. A. Jinnah Road"               || "M. A. Jinnah Road"           || "15"
            "Calle Aduana, 29"                    || "Calle Aduana"                || "29"
            "Way 2259, 2919"                      || "Way 2259"                    || "2919"

            "200 Broadway Av"                     || "Broadway Av"                 || "200"
            "1B HaDoa"                            || "HaDoa"                       || "1B"

            "Calle 39 No 1540"                    || "Calle 39"                    || "No 1540"
            "Calle 34 #24-30"                     || "Calle 34"                    || "#24-30"

            "vul. Centraĺnaja, d. 20"             || "vul. Centraĺnaja"            || "d. 20"
            "str. Pacienței, nr. 9"               || "str. Pacienței"              || "nr. 9"
            "vul. Shevchenka, bud. 17"            || "vul. Shevchenka"             || "bud. 17"

            "Jalan Medan Merdeka Selatan No. 8-9" || "Jalan Medan Merdeka Selatan" || "No. 8-9"
            "C. Francisco I. Madero No. 115"      || "C. Francisco I. Madero"      || "No. 115"
            "vÁrpád fejedelem útja 82."           || "vÁrpád fejedelem"            || "útja 82."
            "Badem Sk. No:13"                     || "Badem Sk."                   || "No:13"

    }

    @Unroll
    def "Parse returns null for #testCase"() {
        given:
            def entries = Collections.singletonList(address)
        when:
            def result = parser.parse(entries)
        then:
            result.getParsedAddresses().get(address) == null
        where:
            testCase                     || address
            "street name without number" || "Badem"
            "only number"                || "121323"
    }

}
