package br.com.furafila.stockapp.model.enums;

import java.util.Objects;

public enum IncomingReasonEnum {

	FIRST_ENTRY, ENTRY;

	public static boolean exists(String incomingReason) {
		return Objects.nonNull(find(incomingReason));
	}

	private static IncomingReasonEnum find(String incomingReason) {
		for (IncomingReasonEnum incomingReasonItem : values()) {
			if (incomingReasonItem.name().equalsIgnoreCase(incomingReason)) {
				return incomingReasonItem;
			}
		}
		return null;
	}
}
