package com.godnedy.address;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static lombok.AccessLevel.PRIVATE;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
@RequestMapping("/api/address")
public class AddressParserController {

    StreetAddressParser parser;

    @PostMapping
    public ResponseEntity<ParseAddressResponse> parse(@RequestBody List<String> addresses) {
        return ResponseEntity.ok(parser.parse(addresses));
    }
}