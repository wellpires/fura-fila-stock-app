package br.com.furafila.stockapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.furafila.stockapp.model.StockIncoming;

public interface StockIncomingRepository extends JpaRepository<StockIncoming, Long> {

}
