package com.chung.os.threads;

import java.util.HashSet;

public class WorkerThread implements Runnable {
	private final String name;
	private final HashSet<String> threadSet;

	public WorkerThread(String name, HashSet<String> threadSet) {
		this.name = name;
		this.threadSet = threadSet;
	}

	@Override
	public void run() {
		threadSet.add(Thread.currentThread().getName());
	}
}
