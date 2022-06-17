package br.com.furafila.stockapp.dto;

public class NewStockProductDTO {

	private Long stockIncomingQuantity;
	private Long productId;
	private Long stockId;

	public Long getStockIncomingQuantity() {
		return stockIncomingQuantity;
	}

	public void setStockIncomingQuantity(Long stockIncomingQuantity) {
		this.stockIncomingQuantity = stockIncomingQuantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

}
