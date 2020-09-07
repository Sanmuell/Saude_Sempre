package br.com.saudesempre.api.service.exceptions;

public class EntityNotFoundExceptions extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EntityNotFoundExceptions(String msg) {
		super(msg);
	}
	
}
