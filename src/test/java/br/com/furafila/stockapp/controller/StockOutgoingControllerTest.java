package br.com.furafila.stockapp.controller;

import static org.mockito.ArgumentMatchers.any;
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

import br.com.furafila.stockapp.dto.NewStockOutgoingDTO;
import br.com.furafila.stockapp.request.NewStockOutgoingRequest;
import br.com.furafila.stockapp.service.StockOutgoingService;
import br.com.furafila.stockapp.util.ReplaceCamelCase;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StockOutgoingController.class)
@DisplayNameGeneration(ReplaceCamelCase.class)
public class StockOutgoingControllerTest {

	private static final String OUTGOING_PATH = "/outgoing";

	@MockBean
	private StockOutgoingService stockOutgoingService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	private NewStockOutgoingRequest newStockOutgoingRequest;

	@BeforeEach
	public void setup() throws StreamReadException, DatabindException, IOException {
		newStockOutgoingRequest = mapper.readValue(
				Paths.get("src", "test", "resources", "NewStockOutgoingRequest.json").toFile(),
				NewStockOutgoingRequest.class);
	}

	@Test
	public void shouldStockOut() throws Exception {

		mockMvc.perform(post(OUTGOING_PATH).content(mapper.writeValueAsString(newStockOutgoingRequest))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent()).andDo(print());

		verify(stockOutgoingService, times(1)).stockOut(any(NewStockOutgoingDTO.class));

	}

	@Test
	public void shouldNotStockOutBecauseStockOutgoingInfoIsNull() throws Exception {

		newStockOutgoingRequest.setNewStockOutgoingDTO(null);

		mockMvc.perform(post(OUTGOING_PATH).content(mapper.writeValueAsString(newStockOutgoingRequest))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest()).andDo(print());

		verify(stockOutgoingService, never()).stockOut(any(NewStockOutgoingDTO.class));

	}

	@Test
	public void shouldNotStockOutBecauseOutgoingReasonIsNull() throws Exception {

		newStockOutgoingRequest.getNewStockOutgoingDTO().setOutgoingReason(null);

		mockMvc.perform(post(OUTGOING_PATH).content(mapper.writeValueAsString(newStockOutgoingRequest))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest()).andDo(print());

		verify(stockOutgoingService, never()).stockOut(any(NewStockOutgoingDTO.class));

	}

	@Test
	public void shouldNotStockOutBecauseOutgoingReasonIsNotValid() throws Exception {

		newStockOutgoingRequest.getNewStockOutgoingDTO().setOutgoingReason("TESTE");

		mockMvc.perform(post(OUTGOING_PATH).content(mapper.writeValueAsString(newStockOutgoingRequest))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest()).andDo(print());

		verify(stockOutgoingService, never()).stockOut(any(NewStockOutgoingDTO.class));

	}

	@Test
	public void shouldNotStockOutBecauseProductIdIsNull() throws Exception {

		newStockOutgoingRequest.getNewStockOutgoingDTO().setProductId(null);

		mockMvc.perform(post(OUTGOING_PATH).content(mapper.writeValueAsString(newStockOutgoingRequest))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest()).andDo(print());

		verify(stockOutgoingService, never()).stockOut(any(NewStockOutgoingDTO.class));

	}

	@Test
	public void shouldNotStockOutBecauseProductIdIsNotValid() throws Exception {

		newStockOutgoingRequest.getNewStockOutgoingDTO().setProductId(0l);

		mockMvc.perform(post(OUTGOING_PATH).content(mapper.writeValueAsString(newStockOutgoingRequest))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest()).andDo(print());

		verify(stockOutgoingService, never()).stockOut(any(NewStockOutgoingDTO.class));

	}

	@Test
	public void shouldNotStockOutBecauseOutgoingQuantityIsNull() throws Exception {

		newStockOutgoingRequest.getNewStockOutgoingDTO().setStockOutgoingQuantity(null);

		mockMvc.perform(post(OUTGOING_PATH).content(mapper.writeValueAsString(newStockOutgoingRequest))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest()).andDo(print());

		verify(stockOutgoingService, never()).stockOut(any(NewStockOutgoingDTO.class));

	}

	@Test
	public void shouldNotStockOutBecauseOutgoingQuantityIsNotValid() throws Exception {

		newStockOutgoingRequest.getNewStockOutgoingDTO().setStockOutgoingQuantity(0l);

		mockMvc.perform(post(OUTGOING_PATH).content(mapper.writeValueAsString(newStockOutgoingRequest))
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest()).andDo(print());

		verify(stockOutgoingService, never()).stockOut(any(NewStockOutgoingDTO.class));

	}

}
