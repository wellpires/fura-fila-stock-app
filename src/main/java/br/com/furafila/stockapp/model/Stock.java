package br.com.furafila.stockapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ESTOQUE")
@Entity
public class Stock implements Serializable {

	private static final long serialVersionUID = -5215400984208012043L;

	@Id
	@Column(name = "id_estoque", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long stockId;

	@Column(name = "id_estabelecimento_FK", columnDefinition = "int4")
	private Long establishmentId;

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Long getEstablishmentId() {
		return establishmentId;
	}

	public void setEstablishmentId(Long establishmentId) {
		this.establishmentId = establishmentId;
	}

}
