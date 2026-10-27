package com.easygest.customerservice.country.adapter.in.web;

import com.easygest.customerservice.country.domain.model.CountryRecord;
import jakarta.validation.constraints.NotBlank;

public record CountryRequest(
        @NotBlank String code,
        @NotBlank String description,
        String prefix) {

    public CountryRecord toRecord() {
        return new CountryRecord(null, code, description, prefix);
    }

    public CountryRecord toRecord(Long id) {
        return new CountryRecord(id, code, description, prefix);
    }
}
