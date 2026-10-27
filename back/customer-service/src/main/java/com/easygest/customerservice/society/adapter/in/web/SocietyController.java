package com.easygest.customerservice.society.adapter.in.web;

import com.easygest.customerservice.society.application.port.in.GetSocietyUseCase;
import com.easygest.customerservice.society.application.port.in.ManageSocietyUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/societies")
@RequiredArgsConstructor
public class SocietyController {

    private final GetSocietyUseCase getSocietyUseCase;
    private final ManageSocietyUseCase manageSocietyUseCase;

    @GetMapping("/all")
    public Flux<SocietyResponse> getAllSocieties() {
        return getSocietyUseCase.getAllSocieties().map(SocietyResponse::from);
    }

    @GetMapping("/{id}")
    public Mono<SocietyResponse> getSocietyById(@PathVariable Long id) {
        return getSocietyUseCase.getSocietyById(id).map(SocietyResponse::from);
    }

    @GetMapping("/public/{publicId}")
    public Mono<SocietyResponse> getSocietyByPublicId(@PathVariable UUID publicId) {
        return getSocietyUseCase.getSocietyByPublicId(publicId).map(SocietyResponse::from);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<SocietyResponse> createSociety(@Valid @RequestBody SocietyRequest request) {
        return manageSocietyUseCase.createSociety(request.toRecord()).map(SocietyResponse::from);
    }

    @PutMapping("/{id}")
    public Mono<SocietyResponse> updateSociety(@PathVariable Long id, @Valid @RequestBody SocietyRequest request) {
        return manageSocietyUseCase.updateSociety(id, request.toRecord(id)).map(SocietyResponse::from);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteSociety(@PathVariable Long id) {
        return manageSocietyUseCase.deleteSociety(id);
    }
}
