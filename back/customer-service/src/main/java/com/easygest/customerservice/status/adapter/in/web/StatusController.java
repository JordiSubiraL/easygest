package com.easygest.customerservice.status.adapter.in.web;

import com.easygest.customerservice.status.application.port.in.GetStatusUseCase;
import com.easygest.customerservice.status.application.port.in.ManageStatusUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/statuses")
@RequiredArgsConstructor
public class StatusController {

    private final GetStatusUseCase getStatusUseCase;
    private final ManageStatusUseCase manageStatusUseCase;

    @GetMapping("/all")
    public Flux<StatusResponse> getAllStatuses() {
        return getStatusUseCase.getAllStatuses().map(StatusResponse::from);
    }

    @GetMapping("/{id}")
    public Mono<StatusResponse> getStatusById(@PathVariable Long id) {
        return getStatusUseCase.getStatusById(id).map(StatusResponse::from);
    }

    @GetMapping("/code/{code}")
    public Mono<StatusResponse> getStatusByCode(@PathVariable String code) {
        return getStatusUseCase.getStatusByCode(code).map(StatusResponse::from);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<StatusResponse> createStatus(@Valid @RequestBody StatusRequest request) {
        return manageStatusUseCase.createStatus(request.toRecord()).map(StatusResponse::from);
    }

    @PutMapping("/{id}")
    public Mono<StatusResponse> updateStatus(@PathVariable Long id, @Valid @RequestBody StatusRequest request) {
        return manageStatusUseCase.updateStatus(id, request.toRecord(id)).map(StatusResponse::from);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteStatus(@PathVariable Long id) {
        return manageStatusUseCase.deleteStatus(id);
    }
}
