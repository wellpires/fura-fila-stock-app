package br.com.furafila.stockapp.exception;

public class StockNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7902479500168927086L;

	public StockNotFoundException() {
		super("Stock not found!");
	}

}
