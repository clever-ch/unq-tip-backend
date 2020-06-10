package root.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidPublicationException extends RuntimeException {
	public InvalidPublicationException(String msg){
        super(msg);
    }
}
