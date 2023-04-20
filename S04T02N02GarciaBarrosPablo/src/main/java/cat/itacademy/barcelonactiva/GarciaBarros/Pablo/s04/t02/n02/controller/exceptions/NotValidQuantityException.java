package cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n02.controller.exceptions;


public class NotValidQuantityException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "LA CANTIDAD INGRESADA NO ES VALIDA";
	
	public NotValidQuantityException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}
}
