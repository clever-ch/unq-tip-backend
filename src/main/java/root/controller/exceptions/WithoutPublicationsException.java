package root.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class WithoutPublicationsException extends RuntimeException {
	
	public WithoutPublicationsException(String msg) {
        super(msg);
    }
}
