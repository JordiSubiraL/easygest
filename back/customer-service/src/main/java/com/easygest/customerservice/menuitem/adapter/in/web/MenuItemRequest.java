package com.easygest.customerservice.menuitem.adapter.in.web;

import com.easygest.customerservice.menuitem.domain.model.MenuItemRecord;
import jakarta.validation.constraints.NotBlank;

public record MenuItemRequest(
        @NotBlank String title,
        @NotBlank String path,
        @NotBlank String icon,
        Long parentId,
        Long displayOrder,
        boolean isActive) {

    public MenuItemRecord toRecord() {
        return new MenuItemRecord(null, title, path, icon, parentId, displayOrder, isActive);
    }

    public MenuItemRecord toRecord(Long id) {
        return new MenuItemRecord(id, title, path, icon, parentId, displayOrder, isActive);
    }
}
