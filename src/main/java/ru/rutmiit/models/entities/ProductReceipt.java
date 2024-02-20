package ru.rutmiit.models.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product_receipts")
public class ProductReceipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductReceiptID")
    private int productReceiptId;

    @Column(name = "WholesalePrice", nullable = false)
    private BigDecimal wholesalePrice;

    @Column(name = "Quantity", nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "ReceiptID", referencedColumnName = "ReceiptID")
    private ReceiptDocument receiptDocument;

    @ManyToOne
    @JoinColumn(name = "ProductID", referencedColumnName = "ProductID")
    private Product product;

    // Getters and Setters
    public int getProductReceiptId() {
        return productReceiptId;
    }

    public void setProductReceiptId(int productReceiptId) {
        this.productReceiptId = productReceiptId;
    }

    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ReceiptDocument getReceiptDocument() {
        return receiptDocument;
    }

    public void setReceiptDocument(ReceiptDocument receiptDocument) {
        this.receiptDocument = receiptDocument;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
