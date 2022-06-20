package br.com.furafila.stockapp.dto;

import javax.validation.GroupSequence;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import br.com.furafila.stockapp.annotation.OutgoingReason;
import br.com.furafila.stockapp.util.Messages;
import br.com.furafila.stockapp.validator.order.FirstOrder;
import br.com.furafila.stockapp.validator.order.SecondOrder;

@GroupSequence({ NewStockOutgoingDTO.class, FirstOrder.class, SecondOrder.class })
public class NewStockOutgoingDTO {

	@NotNull(message = Messages.NEW_STOCK_OUTGOING_QUANTITY_IS_REQUIRED, groups = FirstOrder.class)
	@Min(value = 1, message = Messages.NEW_STOCK_OUTGOING_QUANTITY_IS_NOT_VALID, groups = SecondOrder.class)
	private Long stockOutgoingQuantity;

	@NotNull(message = Messages.NEW_STOCK_OUTGOING_PRODUCT_ID_IS_REQUIRED, groups = FirstOrder.class)
	@Min(value = 1, message = Messages.NEW_STOCK_OUTGOING_PRODUCT_ID_IS_NOT_VALID, groups = SecondOrder.class)
	private Long productId;

	@NotNull(message = Messages.NEW_STOCK_OUTGOING_REASON_IS_REQUIRED, groups = FirstOrder.class)
	@OutgoingReason(message = Messages.NEW_STOCK_OUTGOING_REASON_IS_NOT_VALID, groups = SecondOrder.class)
	private String outgoingReason;

	public Long getStockOutgoingQuantity() {
		return stockOutgoingQuantity;
	}

	public void setStockOutgoingQuantity(Long stockOutgoingQuantity) {
		this.stockOutgoingQuantity = stockOutgoingQuantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getOutgoingReason() {
		return outgoingReason;
	}

	public void setOutgoingReason(String outgoingReason) {
		this.outgoingReason = outgoingReason;
	}

}
