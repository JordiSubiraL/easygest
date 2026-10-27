package com.easygest.customerservice.menuitem.adapter.in.web;

import com.easygest.customerservice.menuitem.application.port.in.GetMenuItemUseCase;
import com.easygest.customerservice.menuitem.application.port.in.ManageMenuItemUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/menu-items")
@RequiredArgsConstructor
public class MenuItemController {

    private final GetMenuItemUseCase getMenuItemUseCase;
    private final ManageMenuItemUseCase manageMenuItemUseCase;

    @GetMapping("/all")
    public Flux<MenuItemResponse> getAllMenuItems() {
        return getMenuItemUseCase.getAllMenuItems().map(MenuItemResponse::from);
    }

    @GetMapping("/{id}")
    public Mono<MenuItemResponse> getMenuItemById(@PathVariable Long id) {
        return getMenuItemUseCase.getMenuItemById(id).map(MenuItemResponse::from);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<MenuItemResponse> createMenuItem(@Valid @RequestBody MenuItemRequest request) {
        return manageMenuItemUseCase.createMenuItem(request.toRecord()).map(MenuItemResponse::from);
    }

    @PutMapping("/{id}")
    public Mono<MenuItemResponse> updateMenuItem(@PathVariable Long id, @Valid @RequestBody MenuItemRequest request) {
        return manageMenuItemUseCase.updateMenuItem(id, request.toRecord(id)).map(MenuItemResponse::from);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteMenuItem(@PathVariable Long id) {
        return manageMenuItemUseCase.deleteMenuItem(id);
    }
}
