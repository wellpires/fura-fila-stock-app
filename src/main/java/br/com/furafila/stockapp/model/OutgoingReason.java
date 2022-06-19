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

import br.com.furafila.stockapp.model.enums.OutgoingReasonEnum;

@Table(name = "MOTIVO_SAIDA")
@Entity
public class OutgoingReason implements Serializable {

	private static final long serialVersionUID = -3882040366377759666L;

	@Id
	@Column(name = "id_motivo", columnDefinition = "serial")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "motivoSaida")
	@Enumerated(EnumType.STRING)
	private OutgoingReasonEnum name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OutgoingReasonEnum getName() {
		return name;
	}

	public void setName(OutgoingReasonEnum name) {
		this.name = name;
	}

}
