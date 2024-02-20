package ru.rutmiit.models.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Revaluations")
public class Revaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RevaluationID")
    private int revaluationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductID", nullable = false)
    private Product product;

    @Column(name = "OldPrice", nullable = false, precision = 10, scale = 2)
    private BigDecimal oldPrice;

    @Column(name = "NewPrice", nullable = false, precision = 10, scale = 2)
    private BigDecimal newPrice;

    @Column(name = "RevaluationDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date revaluationDate;

    // Getters and Setters
    public int getRevaluationId() {
        return revaluationId;
    }

    public void setRevaluationId(int revaluationId) {
        this.revaluationId = revaluationId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(BigDecimal oldPrice) {
        this.oldPrice = oldPrice;
    }

    public BigDecimal getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(BigDecimal newPrice) {
        this.newPrice = newPrice;
    }

    public Date getRevaluationDate() {
        return revaluationDate;
    }

    public void setRevaluationDate(Date revaluationDate) {
        this.revaluationDate = revaluationDate;
    }
}
