package com.easygest.customerservice.menuitem.adapter.in.web;

import com.easygest.customerservice.menuitem.domain.model.MenuItemRecord;

public record MenuItemResponse(
        Long id,
        String title,
        String path,
        String icon,
        Long parentId,
        Long displayOrder,
        boolean isActive) {

    public static MenuItemResponse from(MenuItemRecord record) {
        return new MenuItemResponse(record.id(), record.title(), record.path(), record.icon(),
                record.parentId(), record.displayOrder(), record.isActive());
    }
}
