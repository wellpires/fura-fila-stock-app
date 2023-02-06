package br.com.furafila.stockapp.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.furafila.stockapp.dto.NewStockDTO;
import br.com.furafila.stockapp.util.Messages;

public class NewStockRequest {

	@JsonProperty("stock")
	@NotNull(message = Messages.NEW_STOCK_INFO_IS_REQUIRED)
	@Valid
	private NewStockDTO newStockDTO;

	public NewStockDTO getNewStockDTO() {
		return newStockDTO;
	}

	public void setNewStockDTO(NewStockDTO newStockDTO) {
		this.newStockDTO = newStockDTO;
	}

}
