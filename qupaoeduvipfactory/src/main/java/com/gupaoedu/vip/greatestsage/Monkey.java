package com.gupaoedu.vip.greatestsage;

import java.util.Date;

/**
 * 猴子
 */
public class Monkey {
    protected  int height;//基本类型
    protected int weight;
    protected Date birthday;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
