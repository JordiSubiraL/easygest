package com.easygest.customerservice.menuitem.application.service;

import com.easygest.customerservice.menuitem.application.port.in.GetMenuItemUseCase;
import com.easygest.customerservice.menuitem.application.port.out.MenuItemRepositoryPort;
import com.easygest.customerservice.menuitem.domain.model.MenuItemRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetMenuItemService implements GetMenuItemUseCase {

    private final MenuItemRepositoryPort repositoryPort;

    @Override
    public Flux<MenuItemRecord> getAllMenuItems() {
        return repositoryPort.getAllMenuItems();
    }

    @Override
    public Mono<MenuItemRecord> getMenuItemById(Long id) {
        return repositoryPort.getMenuItemById(id);
    }
}
