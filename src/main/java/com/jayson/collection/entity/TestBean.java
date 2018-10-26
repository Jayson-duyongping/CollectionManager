package com.jayson.collection.entity;

public class TestBean {
    private int id;
    private String name;
    private String description;
    private String auchor;
    private String time;

    public TestBean(int id, String name, String description, String auchor, String time) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.auchor = auchor;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuchor() {
        return auchor;
    }

    public void setAuchor(String auchor) {
        this.auchor = auchor;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
