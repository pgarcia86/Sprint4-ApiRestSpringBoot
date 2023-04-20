
package cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.controllers.exceptions;


public class NotFoundIdException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "NO SE ENCONTRO EL ID BUSCADO";
	
	public NotFoundIdException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}
}
