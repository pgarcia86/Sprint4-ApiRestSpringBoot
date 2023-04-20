package cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n02.controller.exceptions;


//En esta clase construyo el mensaje de error que voy a mostrar.
public class ErrorMessage {
	
	private String exception;
	private String message;
	
	public ErrorMessage(Exception exception) {
		
		this.exception = exception.getClass().getSimpleName();
		this.message = exception.getMessage();	
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}


	@Override
	public String toString() {
		return "ErrorMessage {exception=" + exception + "\\ message=" + message;
	}	
}
