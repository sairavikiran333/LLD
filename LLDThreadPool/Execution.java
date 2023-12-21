package com.test;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Execution {
    private final LinkedBlockingQueue<Runnable> taskQueue;
    private volatile boolean isShutdown = false;
    private final CountDownLatch taskCountDownLatch;

    public Execution(int threadCount, CountDownLatch taskCountDownLatch) {
        taskQueue = new LinkedBlockingQueue<>();
        this.taskCountDownLatch = taskCountDownLatch;
        createThreads(threadCount);
    }

    private void createThreads(int threadCount) {
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new Worker());
            thread.start();
        }
    }

    private class Worker implements Runnable {
        @Override
        public void run() {
            while (!isShutdown) {
                try {
                    Runnable task = taskQueue.take();
                    task.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    public void execute(Runnable task) {
        try {
            if (!isShutdown) {
                taskQueue.put(task);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void shutdown() {
        try {
            taskCountDownLatch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        isShutdown = true;
        for (Thread thread : Thread.getAllStackTraces().keySet()) {
            thread.interrupt();
        }
    }
}
