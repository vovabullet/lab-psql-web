package ru.rutmiit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rutmiit.models.entities.Supplier;
import ru.rutmiit.services.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
    private final SupplierService supplierService;

    @Autowired
    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    public List<Supplier> getAllSuppliers() {
        return supplierService.findAll();
    }

    @PostMapping
    public Supplier saveSupplier(@RequestBody Supplier supplier) {
        return supplierService.save(supplier);
    }
}
