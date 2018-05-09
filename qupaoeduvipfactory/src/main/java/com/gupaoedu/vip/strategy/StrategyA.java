package com.gupaoedu.vip.strategy;

import java.util.Comparator;

public class StrategyA implements Comparator<Long> {
    public int compare(Long o1, Long o2) {
        if(o1<0)
            return 0;
        return (int) (o1-o2);
    }
}
