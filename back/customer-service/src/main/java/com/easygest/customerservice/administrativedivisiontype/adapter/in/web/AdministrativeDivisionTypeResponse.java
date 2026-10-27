package com.easygest.customerservice.administrativedivisiontype.adapter.in.web;

import com.easygest.customerservice.administrativedivisiontype.domain.model.AdministrativeDivisionTypeRecord;

public record AdministrativeDivisionTypeResponse(
        Long id,
        String code,
        String description,
        Long countryId,
        String countryCode) {

    public static AdministrativeDivisionTypeResponse from(AdministrativeDivisionTypeRecord domain) {
        return new AdministrativeDivisionTypeResponse(domain.id(), domain.code(), domain.description(),
                domain.countryId(), domain.countryCode());
    }
}
