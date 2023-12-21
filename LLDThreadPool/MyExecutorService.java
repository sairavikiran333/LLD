package com.test;

import java.util.concurrent.CountDownLatch;

public class MyExecutorService implements MyService{
    private final Execution execution;

    public static MyExecutorService myNewFixedThreadPool(int threadCount, CountDownLatch taskCountDownLatch) {
        return new MyExecutorService(threadCount, taskCountDownLatch);
    }
    
    private MyExecutorService(int threadCount, CountDownLatch taskCountDownLatch) {
        execution = new Execution(threadCount, taskCountDownLatch);
    }

    public void execute(Runnable task) {
        execution.execute(task);
    }

    public void shutdown() {
        execution.shutdown();
    }

	

}
