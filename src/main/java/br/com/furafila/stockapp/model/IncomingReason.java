package br.com.furafila.stockapp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.furafila.stockapp.model.enums.IncomingReasonEnum;

@Table(name = "MOTIVO_ENTRADA")
@Entity
public class IncomingReason implements Serializable {

	private static final long serialVersionUID = 2814296261446910624L;

	@Id
	@Column(name = "id_motivo_entrada", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long incomingReasonId;

	@Column(name = "motivoEntrada")
	@Enumerated(EnumType.STRING)
	private IncomingReasonEnum name;

	public Long getIncomingReasonId() {
		return incomingReasonId;
	}

	public void setIncomingReasonId(Long incomingReasonId) {
		this.incomingReasonId = incomingReasonId;
	}

	public IncomingReasonEnum getName() {
		return name;
	}

	public void setName(IncomingReasonEnum name) {
		this.name = name;
	}

}
