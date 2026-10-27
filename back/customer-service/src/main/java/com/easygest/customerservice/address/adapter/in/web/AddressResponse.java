package com.easygest.customerservice.address.adapter.in.web;

import com.easygest.customerservice.address.domain.model.AddressRecord;

public record AddressResponse(Long id,
                              Long admDivId,
                              String postalCode,
                              String street,
                              String additionalInfo ) {

    public static AddressResponse from(AddressRecord record){
        return new AddressResponse(record.id(), record.admDivId(), record.postalCode(), record.street(), record.additionalInfo());
    }


}
