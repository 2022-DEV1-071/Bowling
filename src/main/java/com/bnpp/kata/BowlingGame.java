package com.bnpp.kata;

import static java.util.Arrays.stream;

class BowlingGame {

	private static final String noScore = "";

	int calculateScore(String input) {
		return stream(input.split(noScore)).mapToInt(Integer::parseInt).sum();
	}

}