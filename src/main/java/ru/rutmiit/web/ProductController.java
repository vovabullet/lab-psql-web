package ru.rutmiit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.rutmiit.models.entities.Product;
import ru.rutmiit.services.ProductService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/products")
    public String showAllProducts(Model model) {
        model.addAttribute("findAll", productService.findAll());
        return "products";
    }

    @GetMapping("/productsBySupplier")
    public String showProductsBySupplier(Model model, @RequestParam("supplierId") Long supplierId) {
        List<Product> products = productService.findProductsBySupplierId(supplierId);
        model.addAttribute("products", products);
        model.addAttribute("supplierId", supplierId);
        return "products-by-supplier";
    }

    @GetMapping("/productsByRevaluation")
    public String showProductsByRevaluation(Model model,
                                            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        List<Product> products = productService.findProductsByRevaluationDateRange(startDate, endDate);
        model.addAttribute("products", products);
        return "products-by-revaluation";
    }
}
