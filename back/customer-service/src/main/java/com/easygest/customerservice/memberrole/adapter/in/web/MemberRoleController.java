package com.easygest.customerservice.memberrole.adapter.in.web;

import com.easygest.customerservice.memberrole.application.port.in.GetMemberRoleUseCase;
import com.easygest.customerservice.memberrole.application.port.in.ManageMemberRoleUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/member-roles")
@RequiredArgsConstructor
public class MemberRoleController {

    private final GetMemberRoleUseCase getMemberRoleUseCase;
    private final ManageMemberRoleUseCase manageMemberRoleUseCase;

    @GetMapping("/all")
    public Flux<MemberRoleResponse> getAllMemberRoles() {
        return getMemberRoleUseCase.getAllMemberRoles().map(MemberRoleResponse::from);
    }

    @GetMapping("/{id}")
    public Mono<MemberRoleResponse> getMemberRoleById(@PathVariable Long id) {
        return getMemberRoleUseCase.getMemberRoleById(id).map(MemberRoleResponse::from);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<MemberRoleResponse> createMemberRole(@Valid @RequestBody MemberRoleRequest request) {
        return manageMemberRoleUseCase.createMemberRole(request.toRecord()).map(MemberRoleResponse::from);
    }

    @PutMapping("/{id}")
    public Mono<MemberRoleResponse> updateMemberRole(@PathVariable Long id, @Valid @RequestBody MemberRoleRequest request) {
        return manageMemberRoleUseCase.updateMemberRole(id, request.toRecord(id)).map(MemberRoleResponse::from);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteMemberRole(@PathVariable Long id) {
        return manageMemberRoleUseCase.deleteMemberRole(id);
    }
}
