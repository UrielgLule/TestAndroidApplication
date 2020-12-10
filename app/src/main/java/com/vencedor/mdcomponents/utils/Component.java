package com.vencedor.mdcomponents.utils;

import java.util.Objects;

public class Component  {

    private String name;
    private int photoRes;
    private  int Type;

    public Component() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhotoRes() {
        return photoRes;
    }

    public void setPhotoRes(int photoRes) {
        this.photoRes = photoRes;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Component component = (Component) o;
        return photoRes == component.photoRes &&
                Type == component.Type &&
                Objects.equals(name, component.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, photoRes, Type);
    }
}
