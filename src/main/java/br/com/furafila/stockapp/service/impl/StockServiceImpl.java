package br.com.furafila.stockapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.furafila.stockapp.dto.NewStockDTO;
import br.com.furafila.stockapp.dto.StockIdDTO;
import br.com.furafila.stockapp.exception.EstablishmentHasNoStockException;
import br.com.furafila.stockapp.exception.StockNotFoundException;
import br.com.furafila.stockapp.model.Stock;
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

	@Override
	public void checkEstablishmentHasStock(Long establishmentId) {
		if (!stockRepository.existsByEstablishmentId(establishmentId)) {
			throw new EstablishmentHasNoStockException();
		}
	}

	@Override
	public void create(NewStockDTO newStockDTO) {

		Stock stock = new Stock();
		stock.setEstablishmentId(newStockDTO.getEstablishmentId());

		stockRepository.save(stock);

	}

}
