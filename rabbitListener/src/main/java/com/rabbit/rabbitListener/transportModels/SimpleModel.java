package com.rabbit.rabbitListener.transportModels;

import java.io.Serializable;

public class SimpleModel implements Serializable {
    private String name;
    private String description;

    public SimpleModel() {
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

    @Override
    public String toString() {
        return "SimpleModel{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
