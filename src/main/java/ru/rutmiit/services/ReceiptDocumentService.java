package ru.rutmiit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.rutmiit.models.entities.ReceiptDocument;
import ru.rutmiit.repositories.ReceiptDocumentRepository;

import java.util.Date;
import java.util.List;

@Service
public class ReceiptDocumentService {
    private final ReceiptDocumentRepository receiptDocumentRepository;

    @Autowired
    public ReceiptDocumentService(ReceiptDocumentRepository receiptDocumentRepository) {
        this.receiptDocumentRepository = receiptDocumentRepository;
    }

    public List<ReceiptDocument> findAll() {
        return receiptDocumentRepository.findAll();
    }

    public ReceiptDocument findById(Long id) {
        return receiptDocumentRepository.findById(id).orElse(null);
    }

    public ReceiptDocument save(ReceiptDocument receiptDocument) {
        return receiptDocumentRepository.save(receiptDocument);
    }
}
