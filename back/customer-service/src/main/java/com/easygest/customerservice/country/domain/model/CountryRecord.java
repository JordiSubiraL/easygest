package com.easygest.customerservice.country.domain.model;

public record CountryRecord(
    Long id,
    String code,
    String description,
    String prefix
) {
}
