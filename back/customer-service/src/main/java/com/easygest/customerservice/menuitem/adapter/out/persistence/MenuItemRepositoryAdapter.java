package com.easygest.customerservice.menuitem.adapter.out.persistence;

import com.easygest.customerservice.menuitem.application.port.out.MenuItemRepositoryPort;
import com.easygest.customerservice.menuitem.domain.model.MenuItemRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class MenuItemRepositoryAdapter implements MenuItemRepositoryPort {

    private final MenuItemR2dbcRepository repository;
    private final MenuItemMapper mapper;

    @Override
    public Flux<MenuItemRecord> getAllMenuItems() {
        return repository.findAll().map(mapper::toDomain);
    }

    @Override
    public Mono<MenuItemRecord> getMenuItemById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Mono<MenuItemRecord> createMenuItem(MenuItemRecord record) {
        return repository.save(mapper.toEntity(record)).map(mapper::toDomain);
    }

    @Override
    public Mono<MenuItemRecord> updateMenuItem(Long id, MenuItemRecord record) {
        return repository.findById(id)
                .flatMap(existing -> {
                    MenuItemEntity entity = mapper.toEntity(record);
                    entity.setId(id);
                    entity.copyAuditingFrom(existing);
                    return repository.save(entity);
                })
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteMenuItem(Long id) {
        return repository.deleteById(id);
    }
}
