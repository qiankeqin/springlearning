package com.gupaoedu.vip.greatestsage;

import java.io.Serializable;

/**
 * 金箍棒
 */
public class GoldRingedStaff implements Serializable{
    private float height = 100;
    private float diameter = 10;

    public void grow(){
        this.diameter *= 2;
        this.height *= 2;
    }

    public void shrink(){
        this.diameter /= 2;
        this.height /= 2;
    }
}
