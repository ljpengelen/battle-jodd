package com.quickstart;

import jodd.madvoc.petite.PetiteWebApplication;
import jodd.madvoc.component.MadvocConfig;
import jodd.madvoc.proxetta.ProxettaAwareActionsManager;
import jodd.petite.PetiteContainer;

/**
 * Web application. Central point for web layer that starts
 * the {@link AppCore application}. Web application can we
 * started without the container!
 */
public class AppWebApplication extends PetiteWebApplication {

	protected final AppCore appCore;

	/**
	 * Creates and starts the web application.
	 */
	public AppWebApplication() {
		appCore = new AppCore();
		appCore.start();
	}

	/**
	 * Registers default and custom Madvoc components.
	 */
	@Override
	public void registerMadvocComponents() {
		super.registerMadvocComponents();

		// use custom madvoc config
		registerComponent(AppMadvocConfig.class);

		// use custom actions manager
		registerComponent(new ProxettaAwareActionsManager(appCore.getProxetta()));
	}

	/**
	 * Defines application container for Madvoc usage. We will share applications
	 * Petite container from the appCore, so Madvoc can use it when creating
	 * Madvoc actions. By sharing the application container with the Madvoc,
	 * Petite beans may be injected in the actions.
	 * <p>
	 * If container is not shared, PetiteWebApplication would create
	 * new Petite container; that is fine when e.g. there are no layers.
	 */
	@Override
	protected PetiteContainer providePetiteContainer() {
		return appCore.getPetite();
	}

	/**
	 * Destroys application context and Madvoc.
	 */
	@Override
	protected void destroy(MadvocConfig madvocConfig) {
		appCore.stop();
		super.destroy(madvocConfig);
	}

}