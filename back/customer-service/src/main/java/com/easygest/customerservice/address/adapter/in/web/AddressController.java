package com.easygest.customerservice.address.adapter.in.web;

import com.easygest.customerservice.address.application.port.in.GetAddressUseCase;
import com.easygest.customerservice.address.application.port.in.ManageAddressUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final GetAddressUseCase getAddressUseCase;
    private final ManageAddressUseCase manageAddressUseCase;

    @GetMapping("/all")
    public Flux<AddressResponse> getAllAddress() {
        return getAddressUseCase.getAllAddress().map(AddressResponse::from);
    }

    @GetMapping("/{id}")
    public Mono<AddressResponse> getAddressById(@PathVariable Long id) {
        return getAddressUseCase.getAddressById(id).map(AddressResponse::from);
    }

    @GetMapping("/adm-div/{admDivId}")
    public Mono<AddressResponse> getAddressByAdmDivId(@PathVariable Long admDivId) {
        return getAddressUseCase.getAddressByAdmDivId(admDivId).map(AddressResponse::from);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<AddressResponse> createAddress(@Valid @RequestBody AddressRequest request) {
        return manageAddressUseCase.createAddress(request.toRecord()).map(AddressResponse::from);
    }

    @PutMapping("/{id}")
    public Mono<AddressResponse> updateAddress(@PathVariable Long id, @Valid @RequestBody AddressRequest request) {
        return manageAddressUseCase.updateAddress(id, request.toRecord(id)).map(AddressResponse::from);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAddress(@PathVariable Long id) {
        return manageAddressUseCase.deleteAddress(id);
    }
}
