package com.gupaoedu.vip.strategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyList {

    public List<Long> sort(List<Long> list,Comparator<Long> comp){
        Collections.sort(list,comp);
        return list;
    }
}
