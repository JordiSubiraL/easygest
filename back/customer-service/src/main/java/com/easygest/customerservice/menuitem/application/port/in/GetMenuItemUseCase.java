package com.easygest.customerservice.menuitem.application.port.in;

import com.easygest.customerservice.menuitem.domain.model.MenuItemRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GetMenuItemUseCase {

    Flux<MenuItemRecord> getAllMenuItems();

    Mono<MenuItemRecord> getMenuItemById(Long id);
}
