package br.com.furafila.stockapp.controller.resource;

import org.springframework.http.ResponseEntity;

import br.com.furafila.stockapp.response.StockInfoResponse;

public interface StockResource {

	ResponseEntity<StockInfoResponse> findStockId(Long establishmentId);
	
}
