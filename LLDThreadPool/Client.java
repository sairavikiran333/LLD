package com.test;
import java.util.concurrent.CountDownLatch;

public class Client {

	public static void main(String[] args) {
		int noOfTasks=10;
		int poolSize=2;
		CountDownLatch allTasksCompleted = new CountDownLatch(noOfTasks);
		MyExecutorService executorService = MyExecutorService.myNewFixedThreadPool(poolSize, allTasksCompleted);

		for (int i = 1; i <= noOfTasks; i++) {
			final int taskNumber = i;
			executorService.execute(new MyTask(taskNumber, allTasksCompleted));
		}

		try {
			allTasksCompleted.await();
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		executorService.shutdown();
	}
}
