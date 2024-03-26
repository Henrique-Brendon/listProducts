package br.com.henrique.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.henrique.system.entities.CodList;

public interface  CodListRepository extends JpaRepository<CodList, Long>{
    
}
