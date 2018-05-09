package com.gupaoedu.vip.simple;

import javafx.beans.property.Property;

import java.util.ArrayList;

//原型模式
public class Prototype implements Cloneable {
    public ArrayList<String> list = new ArrayList<>();
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Prototype prototype = null;
        prototype = (Prototype) super.clone();
        prototype.list = (ArrayList<String>)list.clone();

        return prototype;
    }
}
