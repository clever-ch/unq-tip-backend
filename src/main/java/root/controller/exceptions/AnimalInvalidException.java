package root.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AnimalInvalidException extends RuntimeException  {
	 public AnimalInvalidException(){
	        super("Hay campos en el animal que no pueden estar vacio");
	    }
}
