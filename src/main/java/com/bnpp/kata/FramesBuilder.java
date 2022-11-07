package com.bnpp.kata;

class FramesBuilder {
	private static final String noScore = "";

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
