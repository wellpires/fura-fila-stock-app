package br.com.furafila.stockapp.service;

import br.com.furafila.stockapp.dto.StockIdDTO;

public interface StockService {

	StockIdDTO findStockId(Long establishmentId);

}
