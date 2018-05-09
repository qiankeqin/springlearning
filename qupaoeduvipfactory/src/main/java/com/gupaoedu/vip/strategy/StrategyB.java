package com.gupaoedu.vip.strategy;

import java.util.Comparator;

public class StrategyB implements Comparator<Long> {
    public int compare(Long o1, Long o2) {
        return (int) (o2-o1);
    }
}
