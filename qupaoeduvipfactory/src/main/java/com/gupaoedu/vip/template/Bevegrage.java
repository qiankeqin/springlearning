package com.gupaoedu.vip.template;

//冲饮料模板
public abstract class Bevegrage {
    //不能被重写
    public final void create(){
        //1。把水烧开
        boilWater();
        //2。把杯子准备好
        pourInCup();
        //3。用水冲泡
        brew();
        //4。添加辅料
        addCoundiments();
    }

    protected abstract void brew();

    protected abstract void addCoundiments();

    private void pourInCup() {
        System.out.println("准备杯子");
    }

    private void boilWater() {
        System.out.println("烧开水，烧到100摄氏度！");
    }
}
