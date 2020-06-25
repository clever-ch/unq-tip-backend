package root.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ServiceIncompleteException extends RuntimeException {

	public ServiceIncompleteException(String msg) {
        super(msg);
    }
}
