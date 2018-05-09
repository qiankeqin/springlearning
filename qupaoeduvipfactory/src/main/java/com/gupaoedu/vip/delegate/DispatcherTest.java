package com.gupaoedu.vip.delegate;

public class DispatcherTest {
    public static void main(String[] args) {
        IExcutor excutor = new TargetB();
        //看起来像是我们的项目经理在干活，但实际上是普通员工
        Dispatcher dispatcher = new Dispatcher(excutor);
        dispatcher.doing();
    }
}
