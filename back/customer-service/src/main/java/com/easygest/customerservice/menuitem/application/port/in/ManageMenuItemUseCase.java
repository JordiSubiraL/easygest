package com.easygest.customerservice.menuitem.application.port.in;

import com.easygest.customerservice.menuitem.domain.model.MenuItemRecord;
import reactor.core.publisher.Mono;

public interface ManageMenuItemUseCase {

    Mono<MenuItemRecord> createMenuItem(MenuItemRecord record);

    Mono<MenuItemRecord> updateMenuItem(Long id, MenuItemRecord record);

    Mono<Void> deleteMenuItem(Long id);
}
