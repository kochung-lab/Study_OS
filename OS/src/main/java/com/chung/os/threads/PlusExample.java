package com.chung.os.threads;

import java.util.concurrent.Callable;

public class PlusExample implements Callable<Integer> {
	private int upper;
	public PlusExample(int upper) {
		this.upper = upper;
	}

	public Integer call() {
		int sum = 0;
		for (int i=1; i<=upper; i++) {
			sum += i;
		}
		return Integer.valueOf(sum);
	}
}
