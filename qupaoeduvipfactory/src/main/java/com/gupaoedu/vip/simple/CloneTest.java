package com.gupaoedu.vip.simple;

import java.util.ArrayList;

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        ConcretePrototype cp = new ConcretePrototype();
        cp.setAge(18);
        cp.setName("tom");
        cp.list.add("tom");

        //克隆一份
        //就是有一个现成的对象，这个对象里面有已经设置好的值
        //当我们要"新建一个对象"的时候，并且要给新建的对象赋值，而且赋值内容要跟之前的一摸一样
        //
        ConcretePrototype copy = (ConcretePrototype) cp.clone();
        System.out.println(copy.getAge());
        System.out.println(copy.getName());
        //这里的结果是true，虽然copy和cp是两个对象，但是cp的list和copy的list公用了同一个list，这就是深拷贝
        //此时如果需要实现浅拷贝，需要实现ArrayList的clone
        System.out.println(cp.list == copy.list);

        //如果不使用clone，那么需要这样实现，如果有上百个属性，那么需要很多的赋值代码
        //可以使用反射，但是反射的性能不高
        //我们这里可以使用clone，字节码复，copy字节码后，生成新的对象，这个就是原型模式，在ORM中经常使用到
        ConcretePrototype copy2 = new ConcretePrototype();
        copy2.setAge(cp.getAge());
        copy2.setName(cp.getName());


        System.out.println(copy==cp);

    }
}
