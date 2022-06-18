package br.com.furafila.stockapp.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.furafila.stockapp.dto.NewStockProductDTO;
import br.com.furafila.stockapp.model.StockProduct;
import br.com.furafila.stockapp.repository.StockProductRepository;
import br.com.furafila.stockapp.service.StockProductService;
import br.com.furafila.stockapp.util.ReplaceCamelCase;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(ReplaceCamelCase.class)
public class StockProductServiceImplTest {

	@InjectMocks
	private StockProductService stockProductService = new StockProductServiceImpl();

	@Mock
	private StockProductRepository stockProductRepository;

	@Test
	public void shouldCreateStockProducts() {

		NewStockProductDTO newStockProductDTO = new NewStockProductDTO();
		newStockProductDTO.setProductId(10l);
		newStockProductDTO.setStockIncomingQuantity(10l);
		newStockProductDTO.setStockId(30l);
		stockProductService.createStockProducts(newStockProductDTO);

		verify(stockProductRepository, times(1)).save(any(StockProduct.class));

	}

}
