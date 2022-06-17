package br.com.furafila.stockapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.furafila.stockapp.controller.resource.StockIncomingResource;
import br.com.furafila.stockapp.request.NewStockIncomingRequest;
import br.com.furafila.stockapp.service.StockIncomingService;

@RestController
@RequestMapping("incoming")
public class StockIncomingController implements StockIncomingResource {

	@Autowired
	private StockIncomingService stockIncomingService;
	
	@Override
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> stockIn(@RequestBody @Valid NewStockIncomingRequest stockInRequest) {
		
		stockIncomingService.stockIncoming(stockInRequest.getNewStockIncomingDTO());
		
		return ResponseEntity.noContent().build();
	}

}
