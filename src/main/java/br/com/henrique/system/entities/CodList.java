package br.com.henrique.system.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CodList implements Serializable{
    private static final long serialVersionUID =  1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codList;

    @OneToMany(mappedBy = "codList")
    private List<Product> product = new ArrayList<>();

    public CodList() {}

    public CodList(Long id, String codList) {
        this.id = id;
        this.codList = codList;
    }

    public CodList(Long id, String codList, List<Product> product) {
        this.id = id;
        this.codList = codList;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodList() {
        return codList;
    }

    public void setCodList(String codList) {
        this.codList = codList;
    }

    public List<Product> getProduct() {
        return product;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((codList == null) ? 0 : codList.hashCode());
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
        CodList other = (CodList) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (codList == null) {
            if (other.codList != null)
                return false;
        } else if (!codList.equals(other.codList))
            return false;
        return true;
    } 

    
}
