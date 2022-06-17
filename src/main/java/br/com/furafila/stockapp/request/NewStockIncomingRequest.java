package br.com.furafila.stockapp.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.furafila.stockapp.dto.NewStockIncomingDTO;
import br.com.furafila.stockapp.util.Messages;

public class NewStockIncomingRequest {

	@JsonProperty("stockIncoming")
	@NotNull(message = Messages.NEW_STOCK_INCOMING_INFO_IS_REQUIRED)
	@Valid
	private NewStockIncomingDTO newStockIncomingDTO;

	public NewStockIncomingDTO getNewStockIncomingDTO() {
		return newStockIncomingDTO;
	}

	public void setNewStockIncomingDTO(NewStockIncomingDTO newStockIncomingDTO) {
		this.newStockIncomingDTO = newStockIncomingDTO;
	}

}
