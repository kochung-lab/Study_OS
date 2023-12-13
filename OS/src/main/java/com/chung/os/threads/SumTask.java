package com.chung.os.threads;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer> {
	static final int THRESHOLD = 1000;
	private int begin;
	private int end;
	private int[] array;

	public SumTask(int begin, int end, int[] array) {
		this.begin = begin;
		this.end = end;
		this.array = array;
	}


	protected Integer compute() {
		if (end - begin < THRESHOLD) {
			int sum = 0;
			for (int i=begin; i<=end; i++) {
				sum += array[i];
			}
			return sum;
		}
		else {
			int mid = (begin + end) / 2;

			SumTask leftTask = new SumTask(begin, mid, array);
			SumTask rightTask = new SumTask(mid+1, end, array);

			leftTask.fork();
			rightTask.fork();

			return rightTask.join() + leftTask.join();
		}
	}
}
