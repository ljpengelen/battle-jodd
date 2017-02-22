package com.quickstart;

import jodd.db.DbManager;
import jodd.db.ThreadDbSessionProvider;
import jodd.db.connection.ConnectionProvider;
import jodd.db.oom.DbOomManager;
import jodd.db.oom.config.AutomagicDbOomConfigurator;
import jodd.db.oom.naming.ColumnNamingStrategy;
import jodd.db.oom.naming.TableNamingStrategy;
import jodd.db.pool.CoreConnectionPool;
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

	public void initDb() {
		petite.registerPetiteBean(CoreConnectionPool.class, "dbpool", null, null, false);
		ConnectionProvider cp = (ConnectionProvider) petite.getBean("dbpool");
		cp.init();

		// global settings
		DbManager dbManager = DbManager.getInstance();
		dbManager.setDebug(true);
		dbManager.setConnectionProvider(cp);
		dbManager.setSessionProvider(new ThreadDbSessionProvider());

		DbOomManager dbOomManager = DbOomManager.getInstance();

		// manual configuration (before entities registration)
		TableNamingStrategy tns = new TableNamingStrategy();
		tns.setPrefix("jd_");
		tns.setUppercase(false);
		dbOomManager.setTableNames(tns);

		ColumnNamingStrategy cns = new ColumnNamingStrategy();
		cns.setUppercase(false);
		dbOomManager.setColumnNames(cns);

		// automatic configuration
		AutomagicDbOomConfigurator dbcfg = new AutomagicDbOomConfigurator();
		dbcfg.setIncludedEntries(this.getClass().getPackage().getName() + ".*");
		dbcfg.configure(dbOomManager);
	}

}