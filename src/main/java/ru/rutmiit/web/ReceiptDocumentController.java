package ru.rutmiit.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.rutmiit.models.entities.ReceiptDocument;
import ru.rutmiit.services.ReceiptDocumentService;

import java.util.List;

@RestController
@RequestMapping("/receiptDocuments")
public class ReceiptDocumentController {
    private final ReceiptDocumentService receiptDocumentService;

    @Autowired
    public ReceiptDocumentController(ReceiptDocumentService receiptDocumentService) {
        this.receiptDocumentService = receiptDocumentService;
    }

    @GetMapping
    public List<ReceiptDocument> getAllReceiptDocuments() {
        return receiptDocumentService.findAll();
    }

    @GetMapping("/{id}")
    public ReceiptDocument getReceiptDocumentById(@PathVariable Long id) {
        return receiptDocumentService.findById(id);
    }

    @PostMapping
    public ReceiptDocument saveReceiptDocument(@RequestBody ReceiptDocument receiptDocument) {
        return receiptDocumentService.save(receiptDocument);
    }
}
