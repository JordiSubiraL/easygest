package com.easygest.customerservice.societymember.adapter.in.web;

import com.easygest.customerservice.societymember.application.port.in.GetSocietyMemberUseCase;
import com.easygest.customerservice.societymember.application.port.in.ManageSocietyMemberUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/society-members")
@RequiredArgsConstructor
public class SocietyMemberController {

    private final GetSocietyMemberUseCase getSocietyMemberUseCase;
    private final ManageSocietyMemberUseCase manageSocietyMemberUseCase;

    @GetMapping("/all")
    public Flux<SocietyMemberResponse> getAllSocietyMembers() {
        return getSocietyMemberUseCase.getAllSocietyMembers().map(SocietyMemberResponse::from);
    }

    @GetMapping("/{id}")
    public Mono<SocietyMemberResponse> getSocietyMemberById(@PathVariable Long id) {
        return getSocietyMemberUseCase.getSocietyMemberById(id).map(SocietyMemberResponse::from);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<SocietyMemberResponse> createSocietyMember(@Valid @RequestBody SocietyMemberRequest request) {
        return manageSocietyMemberUseCase.createSocietyMember(request.toRecord()).map(SocietyMemberResponse::from);
    }

    @PutMapping("/{id}")
    public Mono<SocietyMemberResponse> updateSocietyMember(@PathVariable Long id, @Valid @RequestBody SocietyMemberRequest request) {
        return manageSocietyMemberUseCase.updateSocietyMember(id, request.toRecord(id)).map(SocietyMemberResponse::from);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteSocietyMember(@PathVariable Long id) {
        return manageSocietyMemberUseCase.deleteSocietyMember(id);
    }
}
