package com.bnpp.kata;

import java.util.ArrayList;
import java.util.List;
import static com.bnpp.kata.Frame.STRIKE_SIGNAL;

class FramesBuilder {
	private static final String noScore = "";

	List<Frame> build(String inputData) {
		String[] records = inputData.split(noScore);
		List<Frame> frames = new ArrayList<>();
		int indexScore = 0;
		for (; indexScore < records.length - 1; indexScore++) {
			if (frames.size() == 10) {
				break;
			}
			frames.add(buildFrame(records, indexScore));
			if (!isStrike(records[indexScore])) {
				indexScore++;
			}
		}
		if (hasBonus(indexScore, records.length)) {
			frames.add(createBonusFrame(records, indexScore));
		}
		return frames;
	}

	private Frame buildFrame(String[] records, int indexScore) {
		Frame frame = new Frame();
		frame.setFirst(records[indexScore]);
		frame.setBonusScore(false);
		if (!isStrike(records[indexScore])) {
			frame.setSecond(records[indexScore + 1]);
		} else {
			frame.setUpComingRecords(records[indexScore + 1] + records[indexScore + 2]);
		}
		if (frame.isSpare()) {
			frame.setUpComingRecords(records[indexScore + 2]);
		}
		return frame;
	}

	private Frame createBonusFrame(String[] records, int index) {
		String firstRecord = records[index++];
		String secondRecord = noScore;
		if (records.length > index) {
			secondRecord = records[index];
		}
		return createFrame(firstRecord, secondRecord, true);
	}

	private Frame createFrame(String[] records, int indexScore) {
		String firstRecord = records[indexScore++];
		String secondRecord = noScore;
		if (records.length > indexScore) {
			secondRecord = records[indexScore];
		}
		Frame frame = new Frame(firstRecord, secondRecord);
		frame.setBonusScore(true);
		return frame;
	}

}
