package com.chung.os.threads;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleThreadPoolExampleTest {
	@Test
	void 쓰레드풀_쓰레드_개수_테스트() {
		int expected = 5;
		ExecutorService executor = Executors.newFixedThreadPool(expected);

		Set<String> threadSet = new HashSet<>();
		for (int i=0; i<10; i++) {
			Runnable worker = new WorkerThread(i+"번째", threadSet);
			executor.execute(worker);
		}
		executor.shutdown();
		while(!executor.isTerminated()) {
			// threadSet 에 다 넣을 때 까지 기다리는 중
		}
		Assertions.assertEquals(expected, threadSet.size());
	}
}
