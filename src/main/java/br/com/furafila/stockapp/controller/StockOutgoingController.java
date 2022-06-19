package br.com.furafila.stockapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.furafila.stockapp.controller.resource.StockOutgoingResource;
import br.com.furafila.stockapp.request.NewStockOutgoingRequest;
import br.com.furafila.stockapp.service.StockOutgoingService;

@RestController
@RequestMapping("outgoing")
public class StockOutgoingController implements StockOutgoingResource {

	@Autowired
	private StockOutgoingService stockOutgoingService;

	@Override
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> stockOut(@RequestBody NewStockOutgoingRequest newStockOutgoingRequest) {

		stockOutgoingService.stockOut(newStockOutgoingRequest.getNewStockOutgoingDTO());

		return ResponseEntity.noContent().build();
	}

}
