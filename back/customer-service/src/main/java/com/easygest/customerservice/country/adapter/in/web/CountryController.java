package com.easygest.customerservice.country.adapter.in.web;

import com.easygest.customerservice.country.application.port.in.GetCountryUseCase;
import com.easygest.customerservice.country.application.port.in.ManageCountryUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/country")
@RequiredArgsConstructor
public class CountryController {

    private final GetCountryUseCase getCountryUseCase;
    private final ManageCountryUseCase manageCountryUseCase;

    @GetMapping("/all")
    public Flux<CountryResponse> getAllCountries() {
        return getCountryUseCase.getAllCountries().map(CountryResponse::from);
    }

    @GetMapping("/{id}")
    public Mono<CountryResponse> getCountryById(@PathVariable Long id) {
        return getCountryUseCase.getCountryById(id).map(CountryResponse::from);
    }

    @GetMapping("/code/{code}")
    public Mono<CountryResponse> getCountryByCode(@PathVariable String code) {
        return getCountryUseCase.getCountryByCode(code).map(CountryResponse::from);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CountryResponse> createCountry(@Valid @RequestBody CountryRequest request) {
        return manageCountryUseCase.createCountry(request.toRecord()).map(CountryResponse::from);
    }

    @PutMapping("/{id}")
    public Mono<CountryResponse> updateCountry(@PathVariable Long id, @Valid @RequestBody CountryRequest request) {
        return manageCountryUseCase.updateCountry(id, request.toRecord(id)).map(CountryResponse::from);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteCountry(@PathVariable Long id) {
        return manageCountryUseCase.deleteCountry(id);
    }
}
