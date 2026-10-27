package com.easygest.customerservice.address.adapter.in.web;

import com.easygest.customerservice.address.domain.model.AddressRecord;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddressRequest(
        @NotNull Long admDivId,
        @NotBlank String postalCode,
        @NotBlank String street,
        String additionalInfo) {

    public AddressRecord toRecord() {
        return new AddressRecord(null, admDivId, postalCode, street, additionalInfo);
    }

    public AddressRecord toRecord(Long id) {
        return new AddressRecord(id, admDivId, postalCode, street, additionalInfo);
    }
}
