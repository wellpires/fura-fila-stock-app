package br.com.furafila.stockapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.furafila.stockapp.controller.resource.StockResource;
import br.com.furafila.stockapp.dto.StockIdDTO;
import br.com.furafila.stockapp.request.NewStockRequest;
import br.com.furafila.stockapp.response.StockInfoResponse;
import br.com.furafila.stockapp.service.StockService;

@RestController
public class StockController implements StockResource {

	@Autowired
	private StockService stockService;

	@Override
	@GetMapping(path = "establishments/{establishmentId}")
	public ResponseEntity<StockInfoResponse> findStockId(@PathVariable("establishmentId") Long establishmentId) {

		StockIdDTO stockIdDTO = stockService.findStockId(establishmentId);

		return ResponseEntity.ok(new StockInfoResponse(stockIdDTO));
	}

	@Override
	@RequestMapping(path = "establishments/{establishmentId}", method = RequestMethod.HEAD)
	public ResponseEntity<Void> checkEstablishmentHasStock(@PathVariable("establishmentId") Long establishmentId) {
		stockService.checkEstablishmentHasStock(establishmentId);
		return ResponseEntity.ok().build();
	}

	@Override
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> create(@RequestBody NewStockRequest newEstablishmentResponse) {
		stockService.create(newEstablishmentResponse.getNewStockDTO());
		
		return ResponseEntity.noContent().build();
	}

}
