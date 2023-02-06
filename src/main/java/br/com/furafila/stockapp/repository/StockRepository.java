package br.com.furafila.stockapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.furafila.stockapp.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

	Optional<Stock> findByEstablishmentId(Long establishmentId);

	Boolean existsByEstablishmentId(Long establishmentId);
	
}
