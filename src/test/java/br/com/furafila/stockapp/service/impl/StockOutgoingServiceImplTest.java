package br.com.furafila.stockapp.service.impl;

import static br.com.furafila.stockapp.matchers.ZeroValue.zeroValue;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.furafila.stockapp.dto.NewStockOutgoingDTO;
import br.com.furafila.stockapp.exception.OutgoingReasonNotFoundException;
import br.com.furafila.stockapp.model.OutgoingReason;
import br.com.furafila.stockapp.model.StockOutgoing;
import br.com.furafila.stockapp.model.enums.OutgoingReasonEnum;
import br.com.furafila.stockapp.repository.OutgoingReasonRepository;
import br.com.furafila.stockapp.repository.StockOutgoingRepository;
import br.com.furafila.stockapp.service.StockOutgoingService;
import br.com.furafila.stockapp.util.ReplaceCamelCase;

@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(ReplaceCamelCase.class)
public class StockOutgoingServiceImplTest {

	@InjectMocks
	private StockOutgoingService stockOutgoingService = new StockOutgoingServiceImpl();

	@Mock
	private StockOutgoingRepository stockOutgoingRepository;

	@Mock
	private OutgoingReasonRepository outgoingReasonRepository;

	@Test
	public void shouldStockOut() {

		OutgoingReason outgoingReason = new OutgoingReason();
		when(outgoingReasonRepository.findByName(any(OutgoingReasonEnum.class)))
				.thenReturn(Optional.ofNullable(outgoingReason));

		NewStockOutgoingDTO newStockOutgoingDTO = new NewStockOutgoingDTO();
		newStockOutgoingDTO.setOutgoingReason("SALE");
		newStockOutgoingDTO.setStockOutgoingQuantity(10l);
		newStockOutgoingDTO.setProductId(88l);
		stockOutgoingService.stockOut(newStockOutgoingDTO);

		verify(stockOutgoingRepository, times(1)).save(any(StockOutgoing.class));
		ArgumentCaptor<StockOutgoing> outgoingReasonCaptor = ArgumentCaptor.forClass(StockOutgoing.class);
		verify(stockOutgoingRepository).save(outgoingReasonCaptor.capture());

		StockOutgoing stockOutgoingCaught = outgoingReasonCaptor.getValue();

		assertThat(stockOutgoingCaught.getOutgoingQuantity(), allOf(not(nullValue()), not(zeroValue())));
		assertNotNull(stockOutgoingCaught.getOutgoingReason());
		assertThat(stockOutgoingCaught.getProductId(), allOf(not(nullValue()), not(zeroValue())));

	}

	@Test
	public void shouldNotStockOutBecauseOutgoingReasonNotFound() {

		OutgoingReason outgoingReason = null;
		when(outgoingReasonRepository.findByName(any(OutgoingReasonEnum.class)))
				.thenReturn(Optional.ofNullable(outgoingReason));

		NewStockOutgoingDTO newStockOutgoingDTO = new NewStockOutgoingDTO();
		newStockOutgoingDTO.setOutgoingReason("SALE");
		newStockOutgoingDTO.setStockOutgoingQuantity(10l);
		newStockOutgoingDTO.setProductId(88l);

		assertThrows(OutgoingReasonNotFoundException.class, () -> {
			stockOutgoingService.stockOut(newStockOutgoingDTO);
		});

		verify(stockOutgoingRepository, never()).save(any(StockOutgoing.class));

	}

}
