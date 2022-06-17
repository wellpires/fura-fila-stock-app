package br.com.furafila.stockapp.dto;

import javax.validation.GroupSequence;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.furafila.stockapp.annotation.IncomingReason;
import br.com.furafila.stockapp.util.Messages;
import br.com.furafila.stockapp.validator.order.FirstOrder;
import br.com.furafila.stockapp.validator.order.SecondOrder;

@GroupSequence({ NewStockIncomingDTO.class, FirstOrder.class, SecondOrder.class })
public class NewStockIncomingDTO {

	@NotNull(message = Messages.NEW_STOCK_INCOMING_QUANTITY_IS_REQUIRED)
	@Min(value = 1, message = Messages.NEW_STOCK_INCOMING_QUANTITY_IS_NOT_VALID)
	private Long stockIncomingQuantity;

	@NotNull(message = Messages.NEW_STOCK_PRODUCT_ID_IS_REQUIRED)
	@Min(value = 1, message = Messages.NEW_STOCK_PRODUCT_ID_IS_NOT_VALID)
	private Long productId;

	@NotNull(message = Messages.NEW_STOCK_INCOMING_REASON_IS_REQUIRED, groups = FirstOrder.class)
	@IncomingReason(message = Messages.NEW_STOCK_INCOMING_REASON_IS_NOT_VALID, groups = SecondOrder.class)
	@JsonProperty("incomingReason")
	private String incomingReason;

	public Long getStockIncomingQuantity() {
		return stockIncomingQuantity;
	}

	public void setStockIncomingQuantity(Long stockInQuantity) {
		this.stockIncomingQuantity = stockInQuantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getIncomingReason() {
		return incomingReason;
	}

	public void setIncomingReason(String incomingReason) {
		this.incomingReason = incomingReason;
	}

}
