package br.com.henrique.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.henrique.system.entities.Sector;

public interface SectorRepository extends JpaRepository<Sector, Long>{
}
