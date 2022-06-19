package br.com.furafila.stockapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.furafila.stockapp.model.StockOutgoing;

public interface StockOutgoingRepository extends JpaRepository<StockOutgoing, Long> {

}
