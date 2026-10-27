package com.easygest.customerservice.menuitem.adapter.out.persistence;

import com.easygest.customerservice.common.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("menu_item")
public class MenuItemEntity extends AuditableEntity {

    @Id
    private Long id;
    private String title;
    private String path;
    private String icon;
    private Long parentId;
    private Long displayOrder;
    @Column("is_active")
    private boolean isActive;
}
