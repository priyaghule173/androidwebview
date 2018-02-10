package com.space.practise;

/**
 * Created by Pranav on 04/09/2016.
 */
public class Friend {

    private String name;
    private String number;
    private String tag;

    Friend() {
    }

    public Friend(String name, String number, String tag) {
        this.name = name;
        this.number = number;
        this.tag = tag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getTag() {
        return tag;
    }
}
