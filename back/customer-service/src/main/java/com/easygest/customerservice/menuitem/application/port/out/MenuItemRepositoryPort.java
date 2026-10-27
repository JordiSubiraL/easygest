package com.easygest.customerservice.menuitem.application.port.out;

import com.easygest.customerservice.menuitem.domain.model.MenuItemRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MenuItemRepositoryPort {

    Flux<MenuItemRecord> getAllMenuItems();

    Mono<MenuItemRecord> getMenuItemById(Long id);

    Mono<MenuItemRecord> createMenuItem(MenuItemRecord record);

    Mono<MenuItemRecord> updateMenuItem(Long id, MenuItemRecord record);

    Mono<Void> deleteMenuItem(Long id);
}
