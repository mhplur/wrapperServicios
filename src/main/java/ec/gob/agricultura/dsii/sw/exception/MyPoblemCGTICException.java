package ec.gob.agricultura.dsii.sw.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
public class MyPoblemCGTICException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyPoblemCGTICException(String message) {
		super(message);
	}
}
