package capsino.client;

public class YahtzeeClientException extends RuntimeException {

	private static final long serialVersionUID = -8753774773427918755L;

	public YahtzeeClientException(String message, Throwable cause) {
		super(message, cause);
	}

	public YahtzeeClientException(String message) {
		super(message);
	}

}
