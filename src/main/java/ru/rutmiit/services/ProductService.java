package ru.rutmiit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.models.entities.Product;
import ru.rutmiit.repositories.ProductRepository;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findProductsBySupplierId(Long supplierId) {
        return productRepository.findProductsBySupplierId(supplierId);
    }

    public List<String> findProductsByRevaluationDateRange(Date startDate, Date endDate) {
        return productRepository.findProductsByRevaluationDateRange(startDate, endDate);
    }
}
