package br.com.furafila.stockapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.furafila.stockapp.annotation.IncomingReason;
import br.com.furafila.stockapp.model.enums.IncomingReasonEnum;

public class IncomingReasonValidator implements ConstraintValidator<IncomingReason, String> {

	@Override
	public boolean isValid(String incomingReason, ConstraintValidatorContext context) {
		return IncomingReasonEnum.exists(incomingReason);
	}

}
