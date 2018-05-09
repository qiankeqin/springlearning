package com.gupaoedu.vip.strategy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 策略模式
 */
public class MyListTest {
    public static void main(String[] args) {
        List<Long> numbers = new ArrayList<Long>();
        Collections.sort(numbers, new Comparator<Long>() {
            //返回值固定
            //0，-1，1
            //0，<0, >0
            public int compare(Long o1, Long o2) {
                //中间的逻辑不一，即策略不一样
                return (int) (o1-o2);
            }
        });
    }

    @Test
    public void MyListStrategyTest(){
        List<Long> list = new ArrayList<Long>();
        list.add(1L);
        list.add(2L);
        list.add(0L);
        list.add(5L);
        MyList myList = new MyList();
        List<Long> sortList1 = myList.sort(list, new StrategyA());
        List<Long> sortList2 = myList.sort(list, new StrategyB());
        sortList1.forEach(x->{
            System.out.println(x);
        });
        sortList2.forEach(x->{
            System.out.println(x);
        });
    }
}
