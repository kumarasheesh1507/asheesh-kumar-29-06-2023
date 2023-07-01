package com.inventory.management.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "inventory")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@SequenceGenerator(name = "SEQ_INVENTORY", sequenceName = "SEQ_INVENTORY", allocationSize = 50)
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ_INVENTORY")
    private Long id;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "quantity")
    private Long quantity;

}
