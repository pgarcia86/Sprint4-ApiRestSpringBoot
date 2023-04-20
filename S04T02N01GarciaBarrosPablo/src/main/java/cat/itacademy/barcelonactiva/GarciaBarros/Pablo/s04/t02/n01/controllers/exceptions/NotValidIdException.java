package cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.controllers.exceptions;


public class NotValidIdException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "EL ID INGRESADO NO ES CORRECTO";

	public NotValidIdException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

}
