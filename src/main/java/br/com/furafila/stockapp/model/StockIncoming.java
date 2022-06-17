package br.com.furafila.stockapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name = "ESTOQUE_ENTRADA")
@Entity
public class StockIncoming implements Serializable {

	private static final long serialVersionUID = -6192626425218940017L;

	@Id
	@Column(name = "id_estoque_entrada", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "qtdEntrada", columnDefinition = "int4")
	private Long entryQuantity;

	@Column(name = "id_produto_FK", columnDefinition = "int4")
	private Long productId;

	@ManyToOne
	@JoinColumn(name = "id_motivo_entrada", columnDefinition = "int4")
	private IncomingReason incomingReason;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEntryQuantity() {
		return entryQuantity;
	}

	public void setEntryQuantity(Long entryQuantity) {
		this.entryQuantity = entryQuantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public IncomingReason getIncomingReason() {
		return incomingReason;
	}

	public void setIncomingReason(IncomingReason incomingReason) {
		this.incomingReason = incomingReason;
	}

}
