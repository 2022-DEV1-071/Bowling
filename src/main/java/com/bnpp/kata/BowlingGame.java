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
		for (int indexScore1 = 0; indexScore1 < records.length;) {
			frames.add(new Frame(records[indexScore1++], records[indexScore1++]));
		}
		int totalScore = 0;
		for (int indexScore = 0; indexScore < frames.size(); indexScore++) {
			Frame frame = frames.get(indexScore);
			totalScore += frame.calculateScore();
			if (frame.isSpare()) {
				Frame nextFrame = frames.get(indexScore + 1);
				totalScore += nextFrame.getFirstScore();
			}
		}
		return totalScore;
	}
}
