package cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.controllers.exceptions;

public class BadRequestException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "Bad Request Exception (400)";
	
	public BadRequestException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

}
