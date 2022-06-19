package br.com.furafila.stockapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.furafila.stockapp.dto.NewStockOutgoingDTO;
import br.com.furafila.stockapp.exception.OutgoingReasonNotFoundException;
import br.com.furafila.stockapp.model.OutgoingReason;
import br.com.furafila.stockapp.model.StockOutgoing;
import br.com.furafila.stockapp.model.enums.OutgoingReasonEnum;
import br.com.furafila.stockapp.repository.OutgoingReasonRepository;
import br.com.furafila.stockapp.repository.StockOutgoingRepository;
import br.com.furafila.stockapp.service.StockOutgoingService;

@Service
public class StockOutgoingServiceImpl implements StockOutgoingService {

	@Autowired
	private StockOutgoingRepository stockOutgoingRepository;

	@Autowired
	private OutgoingReasonRepository outgoingReasonRepository;

	@Override
	public void stockOut(NewStockOutgoingDTO newStockOutgoingDTO) {

		OutgoingReason outgoingReason = outgoingReasonRepository
				.findByName(OutgoingReasonEnum.valueOf(newStockOutgoingDTO.getOutgoingReason()))
				.orElseThrow(OutgoingReasonNotFoundException::new);

		StockOutgoing stockOutgoing = new StockOutgoing();
		stockOutgoing.setOutgoingQuantity(newStockOutgoingDTO.getStockOutgoingQuantity());
		stockOutgoing.setOutgoingReason(outgoingReason);
		stockOutgoing.setProductId(newStockOutgoingDTO.getProductId());

		stockOutgoingRepository.save(stockOutgoing);

	}

}
