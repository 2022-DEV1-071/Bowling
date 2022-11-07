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

	private Frame createBonusFrame(String[] records, int index) {
		String firstRecord = records[index++];
		String secondRecord = noScore;
		if (records.length > index) {
			secondRecord = records[index];
		}
		Frame frame = new Frame(firstRecord, secondRecord);
		frame.setBonus(true);
		return frame;
	}

	private Frame buildFrame(String[] records, int index) {
		Frame frame = new Frame();
		frame.setFirst(records[index]);
		frame.setBonus(false);
		if (!isStrike(records[index])) {
			frame.setSecond(records[index + 1]);
		} else {
			frame.setUpComingRecords(records[index + 1] + records[index + 2]);
		}
		if (frame.isSpare()) {
			frame.setUpComingRecords(records[index + 2]);
		}
		return frame;
	}

	private boolean isStrike(String record) {
		return STRIKE_SIGNAL.equals(record);
	}

	private boolean hasBonus(int index, int length) {
		return length > index;
	}
}
