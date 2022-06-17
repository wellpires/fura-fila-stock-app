package br.com.furafila.stockapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ESTOQUE_PRODUTOS")
@Entity
public class StockProduct implements Serializable {

	private static final long serialVersionUID = 3341054464927290170L;

	@Id
	@Column(name = "id_estoque_produto", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stockProductId;

	@Column(name = "qtdestoque", columnDefinition = "int4")
	private Long stockQuantity = 0l;

	@Column(name = "id_produto_fk", columnDefinition = "int4")
	private Long productId;

	@Column(name = "id_estoque_fk", columnDefinition = "int4")
	private Long stockId;

	public Long getStockProductId() {
		return stockProductId;
	}

	public void setStockProductId(Long stockProductId) {
		this.stockProductId = stockProductId;
	}

	public Long getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(Long stockQuantity) {
		this.stockQuantity = stockQuantity;
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
