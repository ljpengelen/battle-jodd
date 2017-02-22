package com.quickstart;

import jodd.madvoc.config.RouteMadvocConfigurator;
import jodd.madvoc.result.ServletDispatcherResult;
import jodd.madvoc.result.ServletRedirectResult;

/**
 * Custom Madvoc configurator.
 */
public class AppMadvocConfigurator extends RouteMadvocConfigurator {

	@Override
	public void configure() {
		registerDefaultConfiguration();
		super.configure();
	}

	/**
	 * Registers default configuration stuff so you don't have to put it in the routes file.
	 */
	protected void registerDefaultConfiguration() {
		result(ServletDispatcherResult.class);
		result(ServletRedirectResult.class);
	}
}