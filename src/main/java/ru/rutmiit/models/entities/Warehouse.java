package ru.rutmiit.models.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Warehouses")
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "WarehouseID")
    private int warehouseId;

    @Column(name = "Name", nullable = false, length = 255)
    private String name;

    @Column(name = "Address", nullable = false, length = 255)
    private String address;

    // Getters and Setters
    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
