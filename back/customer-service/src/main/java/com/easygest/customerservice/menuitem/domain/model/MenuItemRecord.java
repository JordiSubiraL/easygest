package com.easygest.customerservice.menuitem.domain.model;

public record MenuItemRecord(
        Long id,
        String title,
        String path,
        String icon,
        Long parentId,
        Long displayOrder,
        boolean isActive) {
}
