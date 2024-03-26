package br.com.henrique.system.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.henrique.system.entities.Product;
import br.com.henrique.system.repositories.ProductRepository;

@Service
public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }

    public List<Product> findAll() {
        Sort sort = Sort.by("price").descending().and(
            Sort.by("name").ascending()
        );
        return repository.findAll(sort);
    }

    public Product insert(Product product) {
        return repository.save(product);
    }

    public Product update(Long id, Product product) {
        Product entity = repository.getReferenceById(id);
        updateData(entity, product);
        return repository.save(entity);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void updateData(Product entity, Product product) {
        entity.setName(product.getName());
        entity.setCost(product.getCost());
        entity.setPrice(product.getPrice());
        entity.setDateEntry(product.getDateEntry());
        entity.setDateExit(product.getDateExit());
        entity.setQuantity(product.getQuantity());
    }

}
