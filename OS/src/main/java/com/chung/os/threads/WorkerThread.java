package com.chung.os.threads;

import java.util.HashSet;
import java.util.Set;

public class WorkerThread implements Runnable {
	private final String name;
	private final Set<String> threadSet;

	public WorkerThread(String name, Set<String> threadSet) {
		this.name = name;
		this.threadSet = threadSet;
	}

	@Override
	public void run() {
		threadSet.add(Thread.currentThread().getName());
	}
}
