package br.com.furafila.stockapp.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.furafila.stockapp.dto.StockIdDTO;

public class StockInfoResponse {

	@JsonProperty("stock")
	private StockIdDTO stockInfoDTO;

	public StockInfoResponse() {
	}

	public StockInfoResponse(StockIdDTO stockIdDTO) {
		stockInfoDTO = stockIdDTO;
	}

	public StockIdDTO getStockInfoDTO() {
		return stockInfoDTO;
	}

	public void setStockInfoDTO(StockIdDTO stockInfoDTO) {
		this.stockInfoDTO = stockInfoDTO;
	}

}
