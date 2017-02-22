package com.quickstart.model;

import jodd.db.oom.meta.DbColumn;
import jodd.db.oom.meta.DbTable;

/**
 * Created by Jonas on 22/02/17.
 */
@DbTable
public class MicroPost {

    @DbColumn
    private long id;
    @DbColumn
    private String user;
    @DbColumn
    private String content;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
