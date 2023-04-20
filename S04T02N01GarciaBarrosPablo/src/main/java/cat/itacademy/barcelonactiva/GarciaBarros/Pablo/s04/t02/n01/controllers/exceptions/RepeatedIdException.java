package cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.controllers.exceptions;

@SuppressWarnings("serial")
public class RepeatedIdException extends BadRequestException{
	
	private static final String DESCRIPTION = "EL ID INGRESADO YA ESTA CARGADO EN LA BASE DE DATOS";

	public RepeatedIdException(String detail) {
		super(DESCRIPTION + ". " + detail);
	}

}
