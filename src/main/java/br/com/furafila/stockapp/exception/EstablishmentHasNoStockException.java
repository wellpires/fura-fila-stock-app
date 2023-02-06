package br.com.furafila.stockapp.exception;

public class EstablishmentHasNoStockException extends RuntimeException {

	private static final long serialVersionUID = -7528140232511884809L;

	public EstablishmentHasNoStockException() {
		super("Establishment has no stock!");
	}
	
}
