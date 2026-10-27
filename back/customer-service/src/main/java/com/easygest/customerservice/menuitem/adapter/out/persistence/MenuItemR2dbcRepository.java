package com.easygest.customerservice.menuitem.adapter.out.persistence;

import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface MenuItemR2dbcRepository extends R2dbcRepository<MenuItemEntity, Long> {
}
