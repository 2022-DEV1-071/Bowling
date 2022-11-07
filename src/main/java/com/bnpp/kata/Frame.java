package com.bnpp.kata;

import static java.lang.Integer.parseInt;

public class Frame {
	public static final String SPARE_SIGNAL = "/";
	public static final String STRIKE_SIGNAL = "X";
	static final String noScore = "";
	static final String LINE = "-";

	private String first;
	private String second;
	private boolean bonusScore;
	private String upComingRecords;

	public Frame(String first, String second) {
		this.first = first;
		this.second = second;
	}

	public boolean isSpare() {
		return SPARE_SIGNAL.endsWith(second);
	}

	public int getFirstScore() {
		return parseInt(first);
	}

	void setBonusScore(boolean bonusScore) {
		this.bonusScore = bonusScore;
	}

	boolean isBonusScore() {
		return bonusScore;
	}

	boolean isStrike() {
		return STRIKE_SIGNAL.equals(first);
	}

	void setUpComingRecords(String upComingRecords) {
		this.upComingRecords = upComingRecords;
	}

	int getBonus() {
		String[] bonuses = upComingRecords.split(noScore);
		int totalBonus = 0;
		for (String bonusScore : bonuses) {
			switch (bonusScore) {
			case "X":
				totalBonus += 10;
				break;
			case "/":
				return 10;
			case "-":
				totalBonus += 0;
				break;
			default:
				totalBonus += parseInt(bonusScore);
			}
		}
		return totalBonus;
	}

	int calculateScore() {
		return isSpare() || isStrike() ? 10 : getFirstScore() + getSecondScore();
	}
	private int getSecondScore() {
		return noScore.equals(second) || LINE.equals(second) ? 0 : parseInt(second);
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public void setSecond(String second) {
		this.second = second;
	}

}
