package br.com.furafila.stockapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.furafila.stockapp.model.OutgoingReason;
import br.com.furafila.stockapp.model.enums.OutgoingReasonEnum;

public interface OutgoingReasonRepository extends JpaRepository<OutgoingReason, Long> {

	Optional<OutgoingReason> findByName(OutgoingReasonEnum name);

}
