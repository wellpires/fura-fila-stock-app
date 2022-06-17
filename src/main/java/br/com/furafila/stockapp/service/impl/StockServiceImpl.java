package br.com.furafila.stockapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.furafila.stockapp.dto.StockIdDTO;
import br.com.furafila.stockapp.exception.StockNotFoundException;
import br.com.furafila.stockapp.repository.StockRepository;
import br.com.furafila.stockapp.service.StockService;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockRepository stockRepository;

	@Override
	public StockIdDTO findStockId(Long establishmentId) {

		Long stockId = stockRepository.findByEstablishmentId(establishmentId).orElseThrow(StockNotFoundException::new)
				.getStockId();

		return new StockIdDTO(stockId);
	}

}
