package com.gupaoedu.vip.greatestsage;

import java.io.*;
import java.util.Date;

/**
 * 齐天大圣
 */
public class TheGreatestSage extends Monkey implements Cloneable,Serializable{
    //金箍棒
    GoldRingedStaff staff;

    TheGreatestSage(){
        this.staff = new GoldRingedStaff();
        this.birthday = new Date();
        this.weight = 30;
        this.height = 150;
    }

    //变化
    public void change() throws CloneNotSupportedException {
        TheGreatestSage copySage = (TheGreatestSage) clone();
        System.out.println("大圣本尊生日："+copySage.getBirthday().getTime());
        System.out.println("克隆大圣的生日："+this.getBirthday().getTime());
        System.out.println("大圣本尊和克隆大圣是否是同一个对象："+(this == copySage));
        System.out.println("大圣的金箍棒是不是一样的："+(this.getStaff() == copySage.getStaff()));

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;


        try {
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            TheGreatestSage copy = (TheGreatestSage) ois.readObject();
            copy.birthday = new Date();
            return copy;//深克隆

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                bis.close();
                bos.close();
                ois.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return super.clone();//浅克隆
    }

    public GoldRingedStaff getStaff() {
        return staff;
    }

    public void setStaff(GoldRingedStaff staff) {
        this.staff = staff;
    }
}
