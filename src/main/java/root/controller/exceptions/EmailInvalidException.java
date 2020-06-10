package root.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class EmailInvalidException extends RuntimeException{
	
	public EmailInvalidException() {
	    super("El email no es valido");
	}
}
