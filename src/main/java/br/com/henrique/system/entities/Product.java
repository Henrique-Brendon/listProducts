package br.com.henrique.system.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product implements Serializable{
    private static final long serialVersionUID =  1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private BigDecimal cost;
    private BigDecimal price;
    private Instant dateEntry;
    private Instant dateExit;
    private Integer quantity;

    public Product(){}

    public Product(Long id, String name, BigDecimal cost, BigDecimal price, Instant dateEntry, Instant dateExit,
            Integer quantity) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.price = price;
        this.dateEntry = dateEntry;
        this.dateExit = dateExit;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Instant getDateEntry() {
        return dateEntry;
    }

    public void setDateEntry(Instant dateEntry) {
        this.dateEntry = dateEntry;
    }

    public Instant getDateExit() {
        return dateExit;
    }

    public void setDateExit(Instant dateExit) {
        this.dateExit = dateExit;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
