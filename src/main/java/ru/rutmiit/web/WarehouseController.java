package ru.rutmiit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rutmiit.models.entities.Warehouse;
import ru.rutmiit.services.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController {
    private final WarehouseService warehouseService;

    @Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping
    public List<Warehouse> getAllWarehouses() {
        return warehouseService.findAll();
    }

    @GetMapping("/{id}")
    public Warehouse getWarehouseById(@PathVariable Long id) {
        return warehouseService.findById(id);
    }

    @PostMapping
    public Warehouse saveWarehouse(@RequestBody Warehouse warehouse) {
        return warehouseService.save(warehouse);
    }
}
