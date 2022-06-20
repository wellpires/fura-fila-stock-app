package br.com.furafila.stockapp.request;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.furafila.stockapp.dto.NewStockOutgoingDTO;
import br.com.furafila.stockapp.util.Messages;

public class NewStockOutgoingRequest {

	@JsonProperty("stockOutgoing")
	@Valid
	@NotNull(message = Messages.NEW_STOCK_OUTGOING_INFO_IS_REQUIRED)
	private NewStockOutgoingDTO newStockOutgoingDTO;

	public NewStockOutgoingDTO getNewStockOutgoingDTO() {
		return newStockOutgoingDTO;
	}

	public void setNewStockOutgoingDTO(NewStockOutgoingDTO newStockOutgoingDTO) {
		this.newStockOutgoingDTO = newStockOutgoingDTO;
	}

}
