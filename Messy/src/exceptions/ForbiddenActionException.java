package exceptions;

public class ForbiddenActionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ForbiddenActionException() {
		super();
	}

	public ForbiddenActionException(String message) {
		super(message);
	}

	public ForbiddenActionException(String message, Throwable cause) {
		super(message, cause);
	}

	public ForbiddenActionException(Throwable cause) {
		super(cause);
	}
}
