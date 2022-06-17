package br.com.furafila.stockapp.service.impl;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.furafila.stockapp.dto.NewStockIncomingDTO;
import br.com.furafila.stockapp.exception.IncomingReasonNotFoundException;
import br.com.furafila.stockapp.model.IncomingReason;
import br.com.furafila.stockapp.model.enums.IncomingReasonEnum;
import br.com.furafila.stockapp.repository.IncomingReasonRepository;
import br.com.furafila.stockapp.repository.StockIncomingRepository;
import br.com.furafila.stockapp.service.StockIncomingService;
import br.com.furafila.stockapp.util.ReplaceCamelCase;

@DisplayNameGeneration(ReplaceCamelCase.class)
@ExtendWith(MockitoExtension.class)
public class StockIncomingServiceImplTest {

	@InjectMocks
	private StockIncomingService stockIncomingService = new StockIncomingServiceImpl();

	@Mock
	private StockIncomingRepository stockIncomingRepository;

	@Mock
	private IncomingReasonRepository incomingReasonRepository;

	@Test
	public void shouldStockIncoming() {

		IncomingReason incomingReason = new IncomingReason();
		when(incomingReasonRepository.findByName(any(IncomingReasonEnum.class)))
				.thenReturn(Optional.ofNullable(incomingReason));

		NewStockIncomingDTO stockInDTO = new NewStockIncomingDTO();
		stockInDTO.setStockIncomingQuantity(10l);
		stockInDTO.setProductId(20l);
		stockInDTO.setIncomingReason("FIRST_ENTRY");
		stockIncomingService.stockIncoming(stockInDTO);

		verify(stockIncomingRepository, times(1)).save(any());

	}

	@Test
	public void shouldNotStockIncomingBecauseIncomingReasonNotFound() {

		IncomingReason incomingReason = null;
		when(incomingReasonRepository.findByName(any(IncomingReasonEnum.class)))
				.thenReturn(Optional.ofNullable(incomingReason));

		NewStockIncomingDTO stockInDTO = new NewStockIncomingDTO();
		stockInDTO.setStockIncomingQuantity(10l);
		stockInDTO.setProductId(20l);
		stockInDTO.setIncomingReason("FIRST_ENTRY");

		assertThrows(IncomingReasonNotFoundException.class, () -> {
			stockIncomingService.stockIncoming(stockInDTO);
		});

		verify(stockIncomingRepository, never()).save(any());

	}

}
