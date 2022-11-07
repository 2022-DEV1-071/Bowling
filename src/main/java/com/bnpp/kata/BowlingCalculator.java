package com.bnpp.kata;

import java.util.List;

public class BowlingCalculator {

	int calculate(List<Frame> frames) {
		int totalScore = 0;
		for (int indexScore = 0; indexScore < frames.size(); indexScore++) {
			totalScore += calculateEachFrame(frames, indexScore);
		}
		return totalScore;
	}

	private int calculateEachFrame(List<Frame> frames, int indexScore) {
		Frame frame = frames.get(indexScore);
		return frame.calculateScore();
	}
}
