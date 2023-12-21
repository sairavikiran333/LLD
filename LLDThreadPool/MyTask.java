package com.test;

import java.util.concurrent.CountDownLatch;

public class MyTask implements Runnable {
    private int i;
    private CountDownLatch taskCountDownLatch;

    public MyTask(int i, CountDownLatch taskCountDownLatch) {
        this.i = i;
        this.taskCountDownLatch = taskCountDownLatch;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " prints " + i);
        taskCountDownLatch.countDown();
    }
}
