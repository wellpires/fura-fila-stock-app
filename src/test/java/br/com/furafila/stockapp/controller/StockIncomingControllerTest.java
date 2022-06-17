package br.com.furafila.stockapp.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.furafila.stockapp.dto.NewStockIncomingDTO;
import br.com.furafila.stockapp.exception.IncomingReasonNotFoundException;
import br.com.furafila.stockapp.request.NewStockIncomingRequest;
import br.com.furafila.stockapp.service.StockIncomingService;
import br.com.furafila.stockapp.util.ReplaceCamelCase;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StockIncomingController.class)
@DisplayNameGeneration(ReplaceCamelCase.class)
public class StockIncomingControllerTest {

	private static final String STOCK_INCOMING_PATH = "/incoming";

	@MockBean
	private StockIncomingService stockIncomingService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	private NewStockIncomingRequest newStockIncomingRequest;

	@BeforeEach
	public void setup() throws StreamReadException, DatabindException, IOException {
		this.newStockIncomingRequest = mapper.readValue(
				Paths.get("src", "test", "resources", "NewStockIncomingRequest.json").toFile(),
				NewStockIncomingRequest.class);
	}

	@Test
	public void shouldStockIn() throws Exception {

		mockMvc.perform(post(STOCK_INCOMING_PATH).content(mapper.writeValueAsString(newStockIncomingRequest))
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isNoContent()).andDo(print());

		verify(stockIncomingService, times(1)).stockIncoming(any());

	}

	@Test
	public void shouldNotStockInBecauseIncomingReasonIsNotFound() throws Exception {

		doThrow(new IncomingReasonNotFoundException()).when(stockIncomingService)
				.stockIncoming(any(NewStockIncomingDTO.class));

		mockMvc.perform(post(STOCK_INCOMING_PATH).content(mapper.writeValueAsString(newStockIncomingRequest))
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isNotFound()).andDo(print());

		verify(stockIncomingService, times(1)).stockIncoming(any());

	}

	@Test
	public void shouldNotStockInBecauseStockIncomingIsNull() throws Exception {

		newStockIncomingRequest.setNewStockIncomingDTO(null);

		mockMvc.perform(post(STOCK_INCOMING_PATH).content(mapper.writeValueAsString(newStockIncomingRequest))
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isBadRequest()).andDo(print());

		verify(stockIncomingService, never()).stockIncoming(any());

	}

	@Test
	public void shouldNotStockInBecauseStockIncomingQuantityIsNull() throws Exception {

		newStockIncomingRequest.getNewStockIncomingDTO().setStockIncomingQuantity(null);

		mockMvc.perform(post(STOCK_INCOMING_PATH).content(mapper.writeValueAsString(newStockIncomingRequest))
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isBadRequest()).andDo(print());

		verify(stockIncomingService, never()).stockIncoming(any());

	}

	@Test
	public void shouldNotStockInBecauseStockIncomingQuantityIsNotValid() throws Exception {

		newStockIncomingRequest.getNewStockIncomingDTO().setStockIncomingQuantity(0l);

		mockMvc.perform(post(STOCK_INCOMING_PATH).content(mapper.writeValueAsString(newStockIncomingRequest))
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isBadRequest()).andDo(print());

		verify(stockIncomingService, never()).stockIncoming(any());

	}

	@Test
	public void shouldNotStockInBecauseProductIdIsNull() throws Exception {

		newStockIncomingRequest.getNewStockIncomingDTO().setProductId(null);

		mockMvc.perform(post(STOCK_INCOMING_PATH).content(mapper.writeValueAsString(newStockIncomingRequest))
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isBadRequest()).andDo(print());

		verify(stockIncomingService, never()).stockIncoming(any());

	}

	@Test
	public void shouldNotStockInBecauseProductIdIsNotValid() throws Exception {

		newStockIncomingRequest.getNewStockIncomingDTO().setProductId(0l);

		mockMvc.perform(post(STOCK_INCOMING_PATH).content(mapper.writeValueAsString(newStockIncomingRequest))
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isBadRequest()).andDo(print());

		verify(stockIncomingService, never()).stockIncoming(any());

	}

	@Test
	public void shouldNotStockInBecauseIncomingReasonEnumIsNull() throws Exception {

		newStockIncomingRequest.getNewStockIncomingDTO().setIncomingReason(null);

		mockMvc.perform(post(STOCK_INCOMING_PATH).content(mapper.writeValueAsString(newStockIncomingRequest))
				.contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isBadRequest()).andDo(print());

		verify(stockIncomingService, never()).stockIncoming(any());

	}

	@Test
	public void shouldNotStockInBecauseIncomingReasonIsNotValid() throws Exception {

		String incomingJson = "{\n" + "    \"stockIncoming\": {\n" + "        \"stockIncomingQuantity\": 10,\n"
				+ "        \"productId\": 10,\n" + "        \"incomingReason\": \"SECOND_ENTRY\"\n" + "    }\n" + "}";

		mockMvc.perform(post(STOCK_INCOMING_PATH).content(incomingJson).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isBadRequest()).andDo(print());

		verify(stockIncomingService, never()).stockIncoming(any());

	}

}
