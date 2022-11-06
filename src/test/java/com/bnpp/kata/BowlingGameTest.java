package com.bnpp.kata;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BowlingGameTest {
	private BowlingGame bowlingGame;

	@Before
	public void setUp() throws Exception {
		bowlingGame = new BowlingGame();
	}

	@Test
	public void noSpareAndNoStrike() throws Exception {
		BowlingGame bowlingGame = new BowlingGame();
		int score = bowlingGame.calculateScore("12345123451234512345");

		assertThat(score, is(0));
	}

	@Test
	public void oneSpareInFirstFrame() throws Exception {
		int score = bowlingGame.calculateScore("5/345123451234512345");

		assertThat(score, is(70));
	}

}