package com.godnedy.address;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class ParseAddressRequest {

    List<String> addresses;
}