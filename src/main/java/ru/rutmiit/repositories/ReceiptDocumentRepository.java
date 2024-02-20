package ru.rutmiit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.rutmiit.models.entities.ReceiptDocument;

import java.util.Date;
import java.util.List;

@Repository
public interface ReceiptDocumentRepository extends JpaRepository<ReceiptDocument, Long> {
    @Query("SELECT rd FROM ReceiptDocument rd WHERE rd.receiptDate = :receiptDate")
    List<ReceiptDocument> findByReceiptDate(@Param("receiptDate") Date receiptDate);
}