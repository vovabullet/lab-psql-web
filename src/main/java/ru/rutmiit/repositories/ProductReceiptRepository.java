package ru.rutmiit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.rutmiit.models.entities.ProductReceipt;

import java.util.List;

@Repository
public interface ProductReceiptRepository extends JpaRepository<ProductReceipt, Long> {

    @Query("SELECT pr FROM ProductReceipt pr WHERE pr.product.productId = :productId")
    List<ProductReceipt> findByProductId(@Param("productId") Long productId);
}
