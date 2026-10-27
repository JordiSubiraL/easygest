package com.easygest.customerservice.address.domain.model;

public record AddressRecord(
        Long id,
        Long admDivId,
        String postalCode,
        String street,
        String additionalInfo
){
}
