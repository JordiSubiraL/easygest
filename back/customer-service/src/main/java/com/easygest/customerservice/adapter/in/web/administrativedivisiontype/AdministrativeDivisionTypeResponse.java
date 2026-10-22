package com.easygest.customerservice.adapter.in.web.administrativedivisiontype;

import com.easygest.customerservice.adapter.in.web.country.CountryResponse;
import com.easygest.customerservice.domain.model.AdministrativeDivisionTypeRecord;

public record AdministrativeDivisionTypeResponse(Long id, String code, String description, String countryCode) {

    public static AdministrativeDivisionTypeResponse from(AdministrativeDivisionTypeRecord domain) {
        return new AdministrativeDivisionTypeResponse(domain.id(), domain.code(), domain.description(), domain.countryCode());
    }
}
