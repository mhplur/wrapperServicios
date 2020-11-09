package ec.gob.agricultura.dsii.sw.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TestException extends HttpMessageNotReadableException {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("deprecation")
	public TestException(String message) {
		super(message);
	}
}
