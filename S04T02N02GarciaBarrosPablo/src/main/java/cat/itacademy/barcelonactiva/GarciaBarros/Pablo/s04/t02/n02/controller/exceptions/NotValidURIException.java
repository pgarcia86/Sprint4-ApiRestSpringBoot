package cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n02.controller.exceptions;

public class NotValidURIException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;
	private static final String DESCRIPTION = "LA PAGINA NO SE HA ENCONTRADO";
	
	public NotValidURIException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}
	

}
