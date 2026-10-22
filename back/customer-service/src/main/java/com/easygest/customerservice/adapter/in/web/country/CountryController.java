package com.easygest.customerservice.adapter.in.web.country;

import com.easygest.customerservice.application.port.in.country.GetCountryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/countries")
@RequiredArgsConstructor
public class CountryController {

    private final GetCountryUseCase getCountryUseCase;

    @GetMapping("/all")
    public Flux<CountryResponse> getAllCountries() {
        return getCountryUseCase.getAllCountries().map(CountryResponse::from);
    }

    @GetMapping("/{code}")
    public Mono<CountryResponse> getCountryByCode(@PathVariable String code) {
        return getCountryUseCase.getCountryByCode(code).map(CountryResponse::from);
    }


}