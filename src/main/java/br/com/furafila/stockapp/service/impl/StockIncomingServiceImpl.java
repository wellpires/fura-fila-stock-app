package br.com.furafila.stockapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.furafila.stockapp.dto.NewStockIncomingDTO;
import br.com.furafila.stockapp.dto.NewStockProductDTO;
import br.com.furafila.stockapp.exception.IncomingReasonNotFoundException;
import br.com.furafila.stockapp.model.IncomingReason;
import br.com.furafila.stockapp.model.StockIncoming;
import br.com.furafila.stockapp.model.enums.IncomingReasonEnum;
import br.com.furafila.stockapp.repository.IncomingReasonRepository;
import br.com.furafila.stockapp.repository.StockIncomingRepository;
import br.com.furafila.stockapp.service.StockIncomingService;
import br.com.furafila.stockapp.service.StockProductService;

@Service
public class StockIncomingServiceImpl implements StockIncomingService {

	@Autowired
	private StockIncomingRepository stockIncomingRepository;

	@Autowired
	private IncomingReasonRepository incomingReasonRepository;

	@Autowired
	private StockProductService stockProductService;

	@Override
	public void stockIncoming(NewStockIncomingDTO stockInDTO) {

		IncomingReasonEnum incomingReasonEnum = IncomingReasonEnum.valueOf(stockInDTO.getIncomingReason());
		if (IncomingReasonEnum.FIRST_ENTRY.equals(incomingReasonEnum)) {
			NewStockProductDTO newStockProductDTO = new NewStockProductDTO();
			newStockProductDTO.setProductId(stockInDTO.getProductId());
			newStockProductDTO.setStockIncomingQuantity(stockInDTO.getStockIncomingQuantity());
			newStockProductDTO.setStockId(stockInDTO.getStockId());
			stockProductService.createStockProducts(newStockProductDTO);
		}

		IncomingReason incomingReason = incomingReasonRepository.findByName(incomingReasonEnum)
				.orElseThrow(IncomingReasonNotFoundException::new);

		StockIncoming stockIncoming = new StockIncoming();
		stockIncoming.setEntryQuantity(stockInDTO.getStockIncomingQuantity());
		stockIncoming.setProductId(stockInDTO.getProductId());
		stockIncoming.setIncomingReason(incomingReason);

		stockIncomingRepository.save(stockIncoming);

	}

}
