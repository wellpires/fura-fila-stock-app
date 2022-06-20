package br.com.furafila.stockapp.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.furafila.stockapp.annotation.OutgoingReason;
import br.com.furafila.stockapp.model.enums.OutgoingReasonEnum;

public class OutgoingReasonValidator implements ConstraintValidator<OutgoingReason, String> {

	@Override
	public boolean isValid(String outgoingReason, ConstraintValidatorContext context) {
		return OutgoingReasonEnum.exists(outgoingReason);
	}

}
