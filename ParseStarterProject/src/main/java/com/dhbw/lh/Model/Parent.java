package com.dhbw.lh.Model;

import java.util.ArrayList;

public class Parent {
    private String title;
    private ArrayList<String> mArrayChildren;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getArrayChildren() {
        return mArrayChildren;
    }

    public void setArrayChildren(ArrayList<String> arrayChildren) {
        mArrayChildren = arrayChildren;
    }
}