package ru.rutmiit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.rutmiit.models.entities.Product;

import java.util.Date;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p.* FROM Products p JOIN product_receipts pr ON p.product_id = pr.productid JOIN receipt_documents rd ON pr.receiptId = rd.receiptId WHERE rd.supplierId = :supplierId", nativeQuery = true)
    List<Product> findProductsBySupplierId(@Param("supplierId") Long supplierId);

    @Query(value = "SELECT p.name FROM Products p JOIN Revaluations r ON p.product_id = r.productId WHERE r.revaluationDate BETWEEN :startDate AND :endDate", nativeQuery = true)
    List<String> findProductsByRevaluationDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}