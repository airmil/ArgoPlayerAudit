/**
 * 
 */
package ddo.argonnessen.argonauts.playeraudit.exception;


/**
 * 
 */
public class PlayerAuditException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new PlayerAuditException.
	 */
	public PlayerAuditException() {
		super();
	}

	/**
	 * Creates a new PlayerAuditException with a message.
	 *
	 * @param message
	 *            the message
	 */
	public PlayerAuditException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new data exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public PlayerAuditException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new data exception.
	 *
	 * @param cause
	 *            the cause
	 */
	public PlayerAuditException(Throwable cause) {
		super(cause);
	}
}
