package br.com.furafila.stockapp.exception;

public class OutgoingReasonNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6873901151489870557L;

	public OutgoingReasonNotFoundException() {
		super("Outgoing Reason not found!");
	}

}
