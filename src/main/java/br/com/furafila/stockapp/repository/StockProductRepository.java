package br.com.furafila.stockapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.furafila.stockapp.model.StockProduct;

public interface StockProductRepository extends JpaRepository<StockProduct, Long> {

}
