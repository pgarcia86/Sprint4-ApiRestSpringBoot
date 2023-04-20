package cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.controllers.exceptions.ErrorMessage;
import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.controllers.exceptions.NotFoundIdException;
import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.controllers.exceptions.NotValidDataException;
import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.controllers.exceptions.NotValidIdException;
import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.controllers.exceptions.NotValidQuantityException;
import cat.itacademy.barcelonactiva.GarciaBarros.Pablo.s04.t02.n01.controllers.exceptions.NotValidURIException;

@RestControllerAdvice
public class ExceptionFrutaController extends ResponseEntityExceptionHandler{
	
		
		@ExceptionHandler
		public ResponseEntity<ErrorMessage> handleException(NotValidIdException e) {
			HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
			return buildResponseEntity(httpStatus, e);
		}
		
		@ExceptionHandler
		public ResponseEntity<ErrorMessage> handleException(NotFoundIdException e){
			HttpStatus httpStatus = HttpStatus.NOT_FOUND;
			return buildResponseEntity(httpStatus, e);
		}	
		
		@ExceptionHandler
		public ResponseEntity<ErrorMessage> handleException(NotValidDataException e){
			HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
			return buildResponseEntity(httpStatus, e);
		}
		
		@ExceptionHandler
		public ResponseEntity<ErrorMessage> handleException(NotValidURIException e){
			HttpStatus httpStatus = HttpStatus.NOT_FOUND;
			return buildResponseEntity(httpStatus, e);
		}
		
		@ExceptionHandler
		public ResponseEntity<ErrorMessage> handleExceptino(NotValidQuantityException e){
			HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
			return buildResponseEntity(httpStatus, e);
		}
		
		private ResponseEntity<ErrorMessage> buildResponseEntity(HttpStatus httpStatus, Exception e){
			
			ErrorMessage error = new ErrorMessage(e);		
			return new ResponseEntity<>(error, httpStatus);
		}
	}
