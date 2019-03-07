package com.cps.www.entity;

public class Poet {
    private String id;
    private String name;

    @Override
    public String toString() {
        return "Poet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Poet(String id, String name) {

        this.id = id;
        this.name = name;
    }

    public Poet() {

    }
}
