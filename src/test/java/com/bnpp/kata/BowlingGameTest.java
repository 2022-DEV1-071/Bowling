package com.bnpp.kata;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingGameTest {
	private BowlingGame bowlingGame;

	@Before
	public void setUp() {
		bowlingGame = new BowlingGame();
	}

	@Test
	public void noSpareAndNoStrike() {

		int score = bowlingGame.getScore("12345123451234512345");

		assertThat(score, is(60));
	}

	@Test
	public void oneSpareInFirstFrame() {
		int score = bowlingGame.getScore("5/345123451234512345");

		assertThat(score, is(70));
	}

	@Test
	public void oneSpareInLastFrame() {
		int score = bowlingGame.getScore("1234512345123451235/5");

		assertThat(score, is(66));
	}

	@Test
	public void oneStrikeInFirstFrame() {
		int score = bowlingGame.getScore("X345123451234512345");

		assertThat(score, is(74));
	}

	@Test
	public void oneStrikeInLastFrame() {
		int score = bowlingGame.getScore("123451234512345123X53");

		assertThat(score, is(69));
	}

	@Test
	public void allSpares() {
		int score = bowlingGame.getScore("5/5/5/5/5/5/5/5/5/5/5");

		assertThat(score, is(150));
	}

	@Test
	public void ninePinsDownEachRound() {
		int score = bowlingGame.getScore("9-9-9-9-9-9-9-9-9-9-");

		assertThat(score, is(90));
	}

	@Test
	public void allStrikes() {
		int score = bowlingGame.getScore("XXXXXXXXXXXX");

		assertThat(score, is(300));
	}

}
