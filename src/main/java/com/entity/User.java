package com.entity;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private Date inserttime;

    public User(int id, String name, Date inserttime) {
        this.id = id;
        this.name = name;
        this.inserttime = inserttime;
    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }
}

