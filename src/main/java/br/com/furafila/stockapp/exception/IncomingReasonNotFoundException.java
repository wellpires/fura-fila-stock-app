package br.com.furafila.stockapp.exception;

public class IncomingReasonNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1194401929321843993L;

	public IncomingReasonNotFoundException() {
		super("Incoming Reason not found!");
	}

}
