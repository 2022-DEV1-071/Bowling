package com.bnpp.kata;

import static java.util.Arrays.stream;
import java.util.ArrayList;
import java.util.List;
import static com.bnpp.kata.Frame.STRIKE_SIGNAL;

class BowlingGame {

	private static final String noScore = "";

	int calculateScore(String inputData) {
	    String[] records = inputData.split(noScore);
	private List<Frame> createFrame(String[] records) {
	    List<Frame> frames = new ArrayList<>();
	    int indexScore = 0;
	    for (indexScore=0; indexScore<records.length - 1; indexScore++ ) {
	      frames.add(new Frame(records[indexScore++], records[indexScore++]));
	      frames.add(createFrame(records[indexScore++], records[indexScore++], false));
	    }
	    if (records.length > indexScore) {
	      Frame frame = new Frame(records[indexScore], "0");
	      frame.setBonusScore(true);
	      frames.add(frame);
	    if (hasBonus(indexScore, records.length)) {
	      frames.add(createFrame(records[indexScore], ZERO, true));
	    }
	    return frame;
	  }
	    if (frame.isStrike()) {
	        Frame nextFrame = frames.get(index + 1);
	        return frame.calculateScore() + nextFrame.getFirstScore() + nextFrame.getSecondScore();
	      }
	      return frame.calculateScore();
	}
}
	
	int getScore(String inputData) {
	    String[] records = inputData.split(noScore);
	    return calculateTotalScore(createFrame(records));
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