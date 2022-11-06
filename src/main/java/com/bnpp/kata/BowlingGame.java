package com.bnpp.kata;

import static java.util.Arrays.stream;
import java.util.ArrayList;
import java.util.List;

class BowlingGame {

	private static final String noScore = "";

	int calculateScore(String input) {
		return stream(input.split(noScore)).mapToInt(Integer::parseInt).sum();
		String[] records = input.split(noScore);
		List<Frame> frames = new ArrayList<>();
		for (int index1 = 0; index1 < records.length;) {
			frames.add(new Frame(records[index1++], records[index1++]));
		}
		int totalScore = 0;
		for (int index = 0; index < frames.size(); index++) {
			Frame frame = frames.get(index);
			totalScore += frame.calculateScore();
			if (frame.isSpare()) {
				Frame nextFrame = frames.get(index + 1);
				totalScore += nextFrame.getFirstScore();
			}
		}
		return totalScore;
	}

}