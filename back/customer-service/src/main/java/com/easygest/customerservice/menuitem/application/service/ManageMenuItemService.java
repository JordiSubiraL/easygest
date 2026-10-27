package com.easygest.customerservice.menuitem.application.service;

import com.easygest.customerservice.menuitem.application.port.in.ManageMenuItemUseCase;
import com.easygest.customerservice.menuitem.application.port.out.MenuItemRepositoryPort;
import com.easygest.customerservice.common.NotFoundException;
import com.easygest.customerservice.menuitem.domain.model.MenuItemRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ManageMenuItemService implements ManageMenuItemUseCase {

    private final MenuItemRepositoryPort repositoryPort;

    @Override
    public Mono<MenuItemRecord> createMenuItem(MenuItemRecord record) {
        return repositoryPort.createMenuItem(record);
    }

    @Override
    public Mono<MenuItemRecord> updateMenuItem(Long id, MenuItemRecord record) {
        return repositoryPort.getMenuItemById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Menu item not found with id " + id)))
                .flatMap(existing -> repositoryPort.updateMenuItem(id, record));
    }

    @Override
    public Mono<Void> deleteMenuItem(Long id) {
        return repositoryPort.getMenuItemById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Menu item not found with id " + id)))
                .flatMap(existing -> repositoryPort.deleteMenuItem(id));
    }
}
