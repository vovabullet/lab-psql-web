package ru.rutmiit.models.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "ReceiptDocuments")
public class ReceiptDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReceiptID")
    private int receiptId;

    @Column(name = "ResponsiblePerson", nullable = false, length = 255)
    private String responsiblePerson;

    @Column(name = "ReceiptDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date receiptDate;

    @ManyToOne
    @JoinColumn(name = "WarehouseID", referencedColumnName = "WarehouseID")
    private Warehouse warehouse;

    @ManyToOne
    @JoinColumn(name = "SupplierID", referencedColumnName = "SupplierID")
    private Supplier supplier;

    // Getters and Setters
    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
