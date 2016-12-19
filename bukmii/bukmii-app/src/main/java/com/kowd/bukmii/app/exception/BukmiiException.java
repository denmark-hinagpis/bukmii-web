package com.kowd.bukmii.app.exception;

/**
 * @author dchinagpis
 *
 */
public class BukmiiException extends Exception {

	private static final long serialVersionUID = 1L;

	/***/
	private final int m_status;

	/**
	 * @param message String
	 */
	public BukmiiException(final String message) {
		this(message, 400);
	}

	/**
	 * @param message String
	 * @param status int
	 */
	public BukmiiException(final String message,
						   final int status) {
		super(message);
		this.m_status = status;
	}

	/**
	 * @param cause Throwable
	 * @param status int
	 */
	public BukmiiException(final Throwable cause,
			   			   final int status) {
		super(cause);
		this.m_status = status;
	}

	/**
	 * @param message String
	 * @param cause Throwable
	 * @param status int
	 */
	public BukmiiException(final String message,
						   final Throwable cause,
						   final int status) {
		super(message, cause);
		this.m_status = status;
	}

	/**
	 * @return int
	 */
	public int getStatus() {
		return m_status;
	}

}
