package cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.controllers.exceptions;

@SuppressWarnings("serial")
public class NotValidDataException extends BadRequestException{
	
	private static final String DESCRIPTION = "EL PARAMETRO INGRESADO NO ES CORRECTO";
	
	public NotValidDataException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}
}
