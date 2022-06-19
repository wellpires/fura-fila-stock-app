package br.com.furafila.stockapp.model.enums;

import java.util.Objects;

public enum OutgoingReasonEnum {

	ADJUSTMENT, SALE;

	public static boolean exists(String incomingReason) {
		return Objects.nonNull(find(incomingReason));
	}

	private static OutgoingReasonEnum find(String outgoingReason) {
		for (OutgoingReasonEnum outgoingReasonItem : values()) {
			if (outgoingReasonItem.name().equalsIgnoreCase(outgoingReason)) {
				return outgoingReasonItem;
			}
		}
		return null;
	}

}
