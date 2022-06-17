package br.com.furafila.stockapp.model.enums;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class IncomingReasonEnumTest {

	@Test
	void shouldExists() {
		assertTrue(IncomingReasonEnum.exists("FIRST_ENTRY"));
	}
	
	@Test
	void shouldNotExists() {
		assertFalse(IncomingReasonEnum.exists("SECOND_ENTRY"));
	}

}
