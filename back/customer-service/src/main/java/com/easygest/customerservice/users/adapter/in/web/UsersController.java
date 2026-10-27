package com.easygest.customerservice.users.adapter.in.web;

import com.easygest.customerservice.users.application.port.in.GetUsersUseCase;
import com.easygest.customerservice.users.application.port.in.ManageUsersUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UsersController {

    private final GetUsersUseCase getUsersUseCase;
    private final ManageUsersUseCase manageUsersUseCase;

    @GetMapping("/all")
    public Flux<UsersResponse> getAllUsers() {
        return getUsersUseCase.getAllUsers().map(UsersResponse::from);
    }

    @GetMapping("/{id}")
    public Mono<UsersResponse> getUsersById(@PathVariable Long id) {
        return getUsersUseCase.getUsersById(id).map(UsersResponse::from);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<UsersResponse> createUsers(@Valid @RequestBody UsersRequest request) {
        return manageUsersUseCase.createUsers(request.toRecord()).map(UsersResponse::from);
    }

    @PutMapping("/{id}")
    public Mono<UsersResponse> updateUsers(@PathVariable Long id, @Valid @RequestBody UsersRequest request) {
        return manageUsersUseCase.updateUsers(id, request.toRecord(id)).map(UsersResponse::from);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteUsers(@PathVariable Long id) {
        return manageUsersUseCase.deleteUsers(id);
    }
}
