package br.com.furafila.stockapp.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.com.furafila.stockapp.util.Messages;

public class NewStockDTO {

	@NotNull(message = Messages.NEW_STOCK_ESTABLISHMENT_ID_REQUIRED)
	@Min(value = 1, message = Messages.NEW_STOCK_ESTABLISHMENT_ID_NOT_VALID)
	private Long establishmentId;

	public Long getEstablishmentId() {
		return establishmentId;
	}

	public void setEstablishmentId(Long establishmentId) {
		this.establishmentId = establishmentId;
	}

}
