package ru.rutmiit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.rutmiit.models.entities.Warehouse;
import ru.rutmiit.services.WarehouseService;

import java.util.List;

@Controller
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

    @GetMapping("/all")
    public String showAllWarehouses(Model model) {
        model.addAttribute("findAll", warehouseService.findAll());
        return "warehouses-all";
    }

    @GetMapping("/bySupplier")
    public String showWarehousesBySupplier(Model model, @RequestParam("supplierId") Long supplierId) {
        List<String> warehouses = warehouseService.findWarehousesBySupplierId(supplierId);
        model.addAttribute("warehouses", warehouses);
        model.addAttribute("supplierId", supplierId);
        return "warehousesList";
    }
}
