package br.com.henrique.system.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product implements Serializable{
    private static final long serialVersionUID =  1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String characteristics;
    private String imgUrl;
    private BigDecimal cost;
    private BigDecimal price;
    private Instant dateEntry;
    private Instant dateExit;
    private Integer quantity;

	@ManyToOne
	@JoinColumn(name = "sector")
	private Sector sector;

    @ManyToOne
    @JoinColumn(name = "codList")
    private CodList codList;

    public Product(){}

    public Product(Long id, String name, String characteristics, String imgUrl, BigDecimal cost, BigDecimal price, Instant dateEntry, Instant dateExit,
            Integer quantity) {
        this.id = id;
        this.name = name;
        this.characteristics = characteristics;
        this.imgUrl = imgUrl;
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

    public String getCharacteristics() {
		return characteristics;
	}

	public void setCharacteristics(String characteristics) {
		this.characteristics = characteristics;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public CodList getCodList() {
        return codList;
    }

    public void setCodList(CodList codList) {
        this.codList = codList;
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

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", cost=" + cost + ", price=" + price + ", dateEntry="
				+ dateEntry + ", dateExit=" + dateExit + ", quantity=" + quantity + ", sector=" + sector + ", codList="
				+ codList + "]";
	}
    
}
