package br.com.henrique.system.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.henrique.system.entities.enums.SectorName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Sector implements Serializable{
    private static final long serialVersionUID =  1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private SectorName name;

    @JsonIgnore
	@OneToMany(mappedBy = "sector")
	private List<Product> product = new ArrayList<>();

    public Sector(){}

    public Sector(SectorName name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SectorName getName() {
        return name;
    }

    public void setName(SectorName name) {
        this.name = name;
    }

    public List<Product> getProduct() {
        return product;
    }

    public static Sector mapSetor(String aux) {
		Map<String, Sector> map = new HashMap<>();
		// NVIDIA
		map.put("GTX 960", new Sector(SectorName.HARDWARE));
		map.put("GTX 970", new Sector(SectorName.HARDWARE));
		map.put("GTX 980", new Sector(SectorName.HARDWARE));
		map.put("GTX 1060", new Sector(SectorName.HARDWARE));
		map.put("GTX 1070", new Sector(SectorName.HARDWARE));
		map.put("GTX 1080", new Sector(SectorName.HARDWARE));
		map.put("GTX 1080 TI", new Sector(SectorName.HARDWARE));
		map.put("RTX 2060", new Sector(SectorName.HARDWARE));
		map.put("RTX 2060 SUPER", new Sector(SectorName.HARDWARE));
		map.put("RTX 2070", new Sector(SectorName.HARDWARE));
		map.put("RTX 2070 TI", new Sector(SectorName.HARDWARE));
		map.put("RTX 2080", new Sector(SectorName.HARDWARE));
		map.put("RTX 2080 TI", new Sector(SectorName.HARDWARE));
		map.put("RTX 3060", new Sector(SectorName.HARDWARE));
		map.put("RTX 3060 TI", new Sector(SectorName.HARDWARE));
		map.put("RTX 3070", new Sector(SectorName.HARDWARE));
		map.put("RTX 3070 TI", new Sector(SectorName.HARDWARE));
		map.put("RTX 3080", new Sector(SectorName.HARDWARE));
		map.put("RTX 3080 TI", new Sector(SectorName.HARDWARE));
		map.put("RTX 3090", new Sector(SectorName.HARDWARE));
		map.put("RTX 3090 TI", new Sector(SectorName.HARDWARE));
		map.put("RTX 4060", new Sector(SectorName.HARDWARE));
		map.put("RTX 4060 TI", new Sector(SectorName.HARDWARE));
		map.put("RTX 4070", new Sector(SectorName.HARDWARE));
		map.put("RTX 4070 TI", new Sector(SectorName.HARDWARE));
		map.put("RTX 4080", new Sector(SectorName.HARDWARE));
		map.put("RTX 4080 TI", new Sector(SectorName.HARDWARE));
		map.put("RTX 4090", new Sector(SectorName.HARDWARE));
		map.put("RTX 4090 TI", new Sector(SectorName.HARDWARE));
		//
		// AMD
		map.put("RYZEN 3 3200G", new Sector(SectorName.HARDWARE));
		map.put("RYZEN 5 3500", new Sector(SectorName.HARDWARE));
		map.put("RYZEN 5 3600", new Sector(SectorName.HARDWARE));
		map.put("RYZEN 5 3600X", new Sector(SectorName.HARDWARE));
		map.put("RYZEN 5 5500", new Sector(SectorName.HARDWARE));
		map.put("RYZEN 5 5600", new Sector(SectorName.HARDWARE));
		map.put("RYZEN 5600G", new Sector(SectorName.HARDWARE));
		map.put("RYZEN 5 5700", new Sector(SectorName.HARDWARE));
		map.put("RYZEN 5 5800", new Sector(SectorName.HARDWARE));
		map.put("RYZEN 5 5800X", new Sector(SectorName.HARDWARE));
		map.put("RX 550", new Sector(SectorName.HARDWARE));
		map.put("RX 560", new Sector(SectorName.HARDWARE));
		map.put("RX 570", new Sector(SectorName.HARDWARE));
		map.put("RX 580", new Sector(SectorName.HARDWARE));
		map.put("RX 590", new Sector(SectorName.HARDWARE));
		map.put("RX 5500", new Sector(SectorName.HARDWARE));
		map.put("RX 5500 XT", new Sector(SectorName.HARDWARE));
		map.put("RX 5600", new Sector(SectorName.HARDWARE));
		map.put("RX 5600 XT", new Sector(SectorName.HARDWARE));
		map.put("RX 5700", new Sector(SectorName.HARDWARE));
		map.put("RX 5700 XT", new Sector(SectorName.HARDWARE));
		map.put("RX 5800", new Sector(SectorName.HARDWARE));
		map.put("RX 5800 XT", new Sector(SectorName.HARDWARE));
		map.put("RX 5900", new Sector(SectorName.HARDWARE));
		map.put("RX 5900 XT", new Sector(SectorName.HARDWARE));
		map.put("RX 6600", new Sector(SectorName.HARDWARE));
		map.put("RX 6600 XT", new Sector(SectorName.HARDWARE));
		map.put("RX 6700 ", new Sector(SectorName.HARDWARE));
		map.put("RX 6700 XT", new Sector(SectorName.HARDWARE));
		
		//
		// INTEL
		map.put("Intel Core i3-8100", new Sector(SectorName.HARDWARE));
		map.put("Intel Core i5-6400", new Sector(SectorName.HARDWARE));
		map.put("Intel Core i5-8500", new Sector(SectorName.HARDWARE));
		map.put("Intel Core i5-8400", new Sector(SectorName.HARDWARE));
		map.put("Intel Core i5-500", new Sector(SectorName.HARDWARE));
		map.put("Intel Core i7-500", new Sector(SectorName.HARDWARE));
        map.put("Intel Core i3-6400", new Sector(SectorName.HARDWARE));
        // SMARTHPHONES
        map.put("Samsung Galaxy S10", new Sector(SectorName.SMARTHPHONES));
        map.put("iPhone 12", new Sector(SectorName.SMARTHPHONES));
        map.put("Google Pixel 5", new Sector(SectorName.SMARTHPHONES));

        // PERIPHELRALS
        map.put("Mouse", new Sector(SectorName.PERIPHELRALS));
        map.put("Keyboard", new Sector(SectorName.PERIPHELRALS));
        map.put("Headphones", new Sector(SectorName.PERIPHELRALS));

		Sector sec = new Sector(SectorName.DEFAULT);

		if (map.get(aux) != null) {
			sec = map.get(aux);
		}
		return sec;
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
        Sector other = (Sector) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return name.name();
    }
}
