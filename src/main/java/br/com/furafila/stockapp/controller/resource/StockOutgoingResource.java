package br.com.furafila.stockapp.controller.resource;

import org.springframework.http.ResponseEntity;

import br.com.furafila.stockapp.request.NewStockOutgoingRequest;

public interface StockOutgoingResource {

	ResponseEntity<Void> stockOut(NewStockOutgoingRequest newStockOutgoingRequest);
	
}
