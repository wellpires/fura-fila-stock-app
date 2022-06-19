package br.com.furafila.stockapp.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.furafila.stockapp.dto.NewStockOutgoingDTO;

public class NewStockOutgoingRequest {

	@JsonProperty("stockOutgoing")
	private NewStockOutgoingDTO newStockOutgoingDTO;

	public NewStockOutgoingDTO getNewStockOutgoingDTO() {
		return newStockOutgoingDTO;
	}

	public void setNewStockOutgoingDTO(NewStockOutgoingDTO newStockOutgoingDTO) {
		this.newStockOutgoingDTO = newStockOutgoingDTO;
	}

}
