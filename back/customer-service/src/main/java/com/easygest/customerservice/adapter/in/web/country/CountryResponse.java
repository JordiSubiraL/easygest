package com.easygest.customerservice.adapter.in.web.country;

import com.easygest.customerservice.domain.model.CountryRecord;

public record CountryResponse(
    String code,
    String description,
    String prefix) {

    public static CountryResponse from(CountryRecord c) {
        return new CountryResponse(c.code(), c.description(), c.prefix());
    }
}
