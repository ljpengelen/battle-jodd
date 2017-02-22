package com.quickstart;

import jodd.joy.core.DefaultAppCore;
import jodd.log.Logger;
import jodd.log.LoggerFactory;
import jodd.log.impl.SimpleLoggerFactory;

/**
 * Application core provided by Jodd.
 */
public class AppCore extends DefaultAppCore {

	/**
	 * Public static reference to application core.
	 * For special cases of accessing app components
	 * outside of container.
	 */
	public static AppCore ref;

	/**
	 * Default constructor.
	 */
	public AppCore() {
		ref = this;
		// don't initialize database
		useDatabase = false;
	}

	/**
	 * Defines logger implementation.
	 */
	@Override
	protected void initLogger() {
		LoggerFactory.setLoggerFactory(new SimpleLoggerFactory(Logger.Level.DEBUG));
		super.initLogger();
	}

}