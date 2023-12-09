package com.chung.os.threads;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.chung.os.threads.PlusExample;

public class PlusExampleTest {
	@Test
	void 더하기() {
		int actual = new PlusExample(5).call();
		Assertions.assertEquals(15, actual);
	}
}
