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

@Table(name = "ESTOQUE_SAIDA")
@Entity
public class StockOutgoing implements Serializable {

	private static final long serialVersionUID = -1411423903377891954L;

	@Id
	@Column(name = "id_estoque_saida", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "qtdSaida", columnDefinition = "int4")
	private Long outgoingQuantity;

	@Column(name = "id_produto_FK", columnDefinition = "int4")
	private Long productId;

	@ManyToOne
	@JoinColumn(name = "id_motivo_FK", columnDefinition = "int4")
	private OutgoingReason outgoingReason;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOutgoingQuantity() {
		return outgoingQuantity;
	}

	public void setOutgoingQuantity(Long outgoingQuantity) {
		this.outgoingQuantity = outgoingQuantity;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public OutgoingReason getOutgoingReason() {
		return outgoingReason;
	}

	public void setOutgoingReason(OutgoingReason outgoingReason) {
		this.outgoingReason = outgoingReason;
	}

}
