package br.com.furafila.stockapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.furafila.stockapp.dto.NewStockIncomingDTO;
import br.com.furafila.stockapp.exception.IncomingReasonNotFoundException;
import br.com.furafila.stockapp.model.IncomingReason;
import br.com.furafila.stockapp.model.StockIncoming;
import br.com.furafila.stockapp.model.enums.IncomingReasonEnum;
import br.com.furafila.stockapp.repository.IncomingReasonRepository;
import br.com.furafila.stockapp.repository.StockIncomingRepository;
import br.com.furafila.stockapp.service.StockIncomingService;

@Service
public class StockIncomingServiceImpl implements StockIncomingService {

	@Autowired
	private StockIncomingRepository stockIncomingRepository;

	@Autowired
	private IncomingReasonRepository incomingReasonRepository;

	@Override
	public void stockIncoming(NewStockIncomingDTO stockInDTO) {

		IncomingReason incomingReason = incomingReasonRepository
				.findByName(IncomingReasonEnum.valueOf(stockInDTO.getIncomingReason()))
				.orElseThrow(IncomingReasonNotFoundException::new);

		StockIncoming stockIncoming = new StockIncoming();
		stockIncoming.setEntryQuantity(stockInDTO.getStockIncomingQuantity());
		stockIncoming.setProductId(stockInDTO.getProductId());
		stockIncoming.setIncomingReason(incomingReason);

		stockIncomingRepository.save(stockIncoming);

	}

}
