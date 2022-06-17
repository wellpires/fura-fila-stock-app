package br.com.furafila.stockapp.service.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.furafila.stockapp.dto.StockIdDTO;
import br.com.furafila.stockapp.exception.StockNotFoundException;
import br.com.furafila.stockapp.model.Stock;
import br.com.furafila.stockapp.repository.StockRepository;
import br.com.furafila.stockapp.service.StockService;
import br.com.furafila.stockapp.util.ReplaceCamelCase;

@DisplayNameGeneration(ReplaceCamelCase.class)
@ExtendWith(MockitoExtension.class)
public class StockServiceImplTest {

	@InjectMocks
	private StockService stockService = new StockServiceImpl();

	@Mock
	private StockRepository stockRepository;

	@Test
	public void shouldFindStockId() {

		Long stockId = 20l;
		Stock stock = new Stock();
		stock.setStockId(stockId);
		when(stockRepository.findByEstablishmentId(anyLong())).thenReturn(Optional.ofNullable(stock));

		StockIdDTO stockIdDTO = stockService.findStockId(10l);

		assertThat(stockIdDTO.getId(), equalTo(stockId));

	}

	@Test
	public void shouldNotFindStockIdBecauseEstablishmentIdNotFound() {

		Stock stock = null;
		when(stockRepository.findByEstablishmentId(anyLong())).thenReturn(Optional.ofNullable(stock));

		assertThrows(StockNotFoundException.class, () -> {
			stockService.findStockId(10l);
		});

	}

}
