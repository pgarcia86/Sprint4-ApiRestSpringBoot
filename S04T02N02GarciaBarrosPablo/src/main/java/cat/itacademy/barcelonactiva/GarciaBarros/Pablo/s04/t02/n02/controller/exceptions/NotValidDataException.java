package cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n02.controller.exceptions;

@SuppressWarnings("serial")
public class NotValidDataException extends BadRequestException{
	
	private static final String DESCRIPTION = "EL PARAMETRO INGRESADO NO ES CORRECTO";
	
	public NotValidDataException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}
}
