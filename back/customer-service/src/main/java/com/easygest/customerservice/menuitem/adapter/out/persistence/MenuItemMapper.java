package com.easygest.customerservice.menuitem.adapter.out.persistence;

import com.easygest.customerservice.menuitem.domain.model.MenuItemRecord;
import org.springframework.stereotype.Component;

@Component
public class MenuItemMapper {

    public MenuItemRecord toDomain(MenuItemEntity entity) {
        return new MenuItemRecord(entity.getId(), entity.getTitle(), entity.getPath(), entity.getIcon(),
                entity.getParentId(), entity.getDisplayOrder(), entity.isActive());
    }

    public MenuItemEntity toEntity(MenuItemRecord record) {
        return new MenuItemEntity(record.id(), record.title(), record.path(), record.icon(),
                record.parentId(), record.displayOrder(), record.isActive());
    }
}
