package com.easygest.customerservice.administrativedivision.adapter.in.web;

import com.easygest.customerservice.administrativedivision.domain.model.AdministrativeDivisionRecord;

public record AdministrativeDivisionResponse(
        Long id,
        Long countryId,
        Long admDivTypeId,
        Long parentId,
        String code,
        String description) {

    public static AdministrativeDivisionResponse from(AdministrativeDivisionRecord record) {
        return new AdministrativeDivisionResponse(record.id(), record.countryId(), record.admDivTypeId(),
                record.parentId(), record.code(), record.description());
    }
}
