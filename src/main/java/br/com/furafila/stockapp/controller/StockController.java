package br.com.furafila.stockapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.furafila.stockapp.controller.resource.StockResource;
import br.com.furafila.stockapp.dto.StockIdDTO;
import br.com.furafila.stockapp.response.StockInfoResponse;
import br.com.furafila.stockapp.service.StockService;

@RestController
public class StockController implements StockResource {

	@Autowired
	private StockService stockService;

	@Override
	@GetMapping(path = "/{establishmentId}")
	public ResponseEntity<StockInfoResponse> findStockId(@PathVariable("establishmentId") Long establishmentId) {

		StockIdDTO stockIdDTO = stockService.findStockId(establishmentId);

		return ResponseEntity.ok(new StockInfoResponse(stockIdDTO));
	}

}
