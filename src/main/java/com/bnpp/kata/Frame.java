package com.bnpp.kata;

import static java.lang.Integer.parseInt;

public class Frame {
	static final String STRIKE_SIGNAL = "X";
	static final String SPARE_SIGNAL = "/";
	static final String noScore = "";
	static final String LINE = "-";
	private String first;
	private String second;
	private boolean bonus;
	private String upComingRecords;

	Frame(String first, String second) {
		this.first = first;
		this.second = second;
	}

	Frame() {

	}

	int calculateScore() {
		return isSpare() || isStrike() ? 10 : getFirstScore() + getSecondScore();
	}

	private int getSecondScore() {
		return noScore.equals(second) || LINE.equals(second) ? 0 : parseInt(second);
	}

	boolean isStrike() {
		return STRIKE_SIGNAL.equals(first);
	}

	boolean isSpare() {
		return SPARE_SIGNAL.equals(second);
	}

	int getFirstScore() {
		return noScore.equals(first) || LINE.equals(first) ? 0 : parseInt(first);
	}

	void setBonus(boolean bonus) {
		this.bonus = bonus;
	}

	boolean isBonus() {
		return bonus;
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

	public void setFirst(String first) {
		this.first = first;
	}

	public void setSecond(String second) {
		this.second = second;
	}

}
