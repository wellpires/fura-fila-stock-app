package br.com.furafila.stockapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.furafila.stockapp.model.IncomingReason;
import br.com.furafila.stockapp.model.enums.IncomingReasonEnum;

public interface IncomingReasonRepository extends JpaRepository<IncomingReason, Long> {

	Optional<IncomingReason> findByName(IncomingReasonEnum name);

}
