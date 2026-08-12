package com.cvalcoding.sample_project_javafx.config;

import org.apache.logging.log4j.Logger;

public class Log {

	private static final Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger();

	private Log() {
	}

	/**
	 *
	 * @param msg string for info msg
	 */
	public static void info(String msg) {
		LOGGER.info(msg);
	}

	/**
	 *
	 * @param msg string for warn msg
	 */
	public static void warn(String msg) {
		LOGGER.warn(msg);
	}

	/**
	 *
	 * @param msg string for error msg
	 */
	public static void error(String msg) {
		LOGGER.error(msg);
	}
}
