package br.com.furafila.stockapp.controller.resource;

import org.springframework.http.ResponseEntity;

import br.com.furafila.stockapp.request.NewStockIncomingRequest;

public interface StockIncomingResource {

	ResponseEntity<Void> stockIn(NewStockIncomingRequest stockInResponse);

}
