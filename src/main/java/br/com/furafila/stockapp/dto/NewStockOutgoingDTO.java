package br.com.furafila.stockapp.dto;

public class NewStockOutgoingDTO {

	private Long stockOutgoingQuantity;
	private Long productId;
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
