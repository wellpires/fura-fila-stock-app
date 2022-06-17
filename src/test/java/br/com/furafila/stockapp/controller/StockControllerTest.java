package br.com.furafila.stockapp.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.furafila.stockapp.dto.StockIdDTO;
import br.com.furafila.stockapp.exception.StockNotFoundException;
import br.com.furafila.stockapp.response.StockInfoResponse;
import br.com.furafila.stockapp.service.StockService;
import br.com.furafila.stockapp.util.ReplaceCamelCase;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StockController.class)
@DisplayNameGeneration(ReplaceCamelCase.class)
public class StockControllerTest {

	private static final String STOCK_PATH = "/{establishmentId}";

	@MockBean
	private StockService stockService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	public void shouldFindStockId() throws Exception {

		Long stockId = 321l;
		StockIdDTO stockIdDTO = new StockIdDTO();
		stockIdDTO.setId(stockId);
		when(stockService.findStockId(anyLong())).thenReturn(stockIdDTO);

		HashMap<String, Object> param = new HashMap<>();
		param.put("establishmentId", 123l);

		String path = UriComponentsBuilder.fromPath(STOCK_PATH).buildAndExpand(param).toUriString();

		MvcResult result = mockMvc.perform(get(path).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andDo(print()).andReturn();

		StockInfoResponse stockInfoResponse = mapper.readValue(result.getResponse().getContentAsString(),
				StockInfoResponse.class);

		assertNotNull(stockInfoResponse);
		assertNotNull(stockInfoResponse.getStockInfoDTO());
		assertThat(stockInfoResponse.getStockInfoDTO().getId(), equalTo(stockId));

	}

	@Test
	public void shouldNotFindStockIdBecauseEstablishmentIdNotFound() throws Exception {

		Long stockId = 321l;
		StockIdDTO stockIdDTO = new StockIdDTO();
		stockIdDTO.setId(stockId);
		when(stockService.findStockId(anyLong())).thenThrow(new StockNotFoundException());

		HashMap<String, Object> param = new HashMap<>();
		param.put("establishmentId", 123l);

		String path = UriComponentsBuilder.fromPath(STOCK_PATH).buildAndExpand(param).toUriString();

		mockMvc.perform(get(path).contentType(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isNotFound())
				.andDo(print()).andReturn();

	}

}
