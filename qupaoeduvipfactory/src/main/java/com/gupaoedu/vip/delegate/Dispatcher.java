package com.gupaoedu.vip.delegate;

public class Dispatcher implements IExcutor {

    IExcutor executor;

    Dispatcher(IExcutor executor){
        this.executor = executor;
    }

    //项目经历，虽然也有执行方法
    //但是工作指责不一样，
    //工作职责是分配任务
    public void doing() {
        executor.doing();
    }
}
