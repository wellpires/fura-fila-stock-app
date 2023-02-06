package br.com.furafila.stockapp.service;

import br.com.furafila.stockapp.dto.NewStockDTO;
import br.com.furafila.stockapp.dto.StockIdDTO;

public interface StockService {

	StockIdDTO findStockId(Long establishmentId);

	void checkEstablishmentHasStock(Long establishmentId);

	void create(NewStockDTO newStockDTO);

}
