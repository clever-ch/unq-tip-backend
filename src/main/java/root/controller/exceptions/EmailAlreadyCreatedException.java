package root.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class EmailAlreadyCreatedException extends RuntimeException {
	
	public EmailAlreadyCreatedException() {
	    super("El email ya existe, por favor usar uno nuevo");
	}
}
