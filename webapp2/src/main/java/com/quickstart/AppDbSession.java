package com.quickstart;

import jodd.db.DbSession;
import jodd.db.ThreadDbSessionHolder;
import jodd.db.connection.ConnectionProvider;
import jodd.petite.meta.PetiteBean;
import jodd.petite.meta.PetiteInject;

/**
 * Created by laurensk on 22/02/2017.
 */
@PetiteBean
public class AppDbSession {

    @PetiteInject
    ConnectionProvider dbpool;

    public void start() {
        DbSession dbSession = new DbSession(dbpool);
        ThreadDbSessionHolder.set(dbSession);
    }

    public void stop() {
        ThreadDbSessionHolder.remove();
    }
}
