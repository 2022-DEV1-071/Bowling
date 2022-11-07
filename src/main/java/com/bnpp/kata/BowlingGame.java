package com.bnpp.kata;

import static java.util.Arrays.stream;
import java.util.ArrayList;
import java.util.List;

class BowlingGame {

	private static final String noScore = "";

	int calculateScore(String inputData) {
	    String[] records = inputData.split(noScore);
	private List<Frame> buildFrames(String[] records) {
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
	    return frames;
	  }
}
}
}