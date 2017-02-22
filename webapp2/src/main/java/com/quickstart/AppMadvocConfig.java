package com.quickstart;

import com.quickstart.actions.IndexAction;
import jodd.madvoc.component.MadvocConfig;
import jodd.servlet.CsrfShield;
import jodd.upload.impl.AdaptiveFileUploadFactory;

/**
 * Custom application Madvoc configuration. This is also a good place
 * for any other web configuration.
 * <p>
 * Additionally/alternately, 'madvoc.props' is also used for
 * Madvoc configuration.
 */
public class AppMadvocConfig extends MadvocConfig {

	public AppMadvocConfig() {
		super();

		fileUploadFactory = new AdaptiveFileUploadFactory();

		getRootPackages().addRootPackageOf(IndexAction.class);

		// additional web config
		CsrfShield.setTimeToLive(0);
	}
}
