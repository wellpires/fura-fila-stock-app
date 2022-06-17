package br.com.furafila.stockapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.furafila.stockapp.dto.NewStockProductDTO;
import br.com.furafila.stockapp.model.StockProduct;
import br.com.furafila.stockapp.repository.StockProductRepository;
import br.com.furafila.stockapp.service.StockProductService;

@Service
public class StockProductServiceImpl implements StockProductService {

	@Autowired
	private StockProductRepository stockProductRepository;

	@Override
	public void createStockProducts(NewStockProductDTO newStockProductDTO) {

		StockProduct stockProduct = new StockProduct();
		stockProduct.setProductId(newStockProductDTO.getProductId());
		stockProduct.setStockQuantity(newStockProductDTO.getStockIncomingQuantity());
		stockProduct.setStockId(newStockProductDTO.getStockId());
		stockProductRepository.save(stockProduct);

	}

}
