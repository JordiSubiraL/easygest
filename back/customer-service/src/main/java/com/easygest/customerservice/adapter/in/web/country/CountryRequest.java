package com.easygest.customerservice.adapter.in.web.country;

import lombok.Data;

@Data
public class CountryRequest {
    private String code;
    private String description;
    private String prefix;

    public CountryRequest(String code, String description, String prefix) {
        this.code = code;
        this.description = description;
        this.prefix = prefix;
    }

    static CountryRequest of(String code, String description, String prefix) {
        return new CountryRequest(code, description, prefix);
    }
}
