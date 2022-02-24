package br.com.unifacisa.lti.exception;

public class SaldoInsuficienteException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public SaldoInsuficienteException() {
		super("saldo insuficiente!");
	}

}
