package root.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyCreatedExceptions extends RuntimeException {
	
	public UserAlreadyCreatedExceptions() {
	    super("El usuario ya existe, por favor crear uno nuevo");
	}
}
