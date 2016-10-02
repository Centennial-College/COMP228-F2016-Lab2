package exercise2;

import java.security.SecureRandom;
import javax.swing.JOptionPane;

/**
 * This class simulates a Lotto game. The user will choose a number between 3 to
 * 27. If the Lotto generated sum does not match the number, the user loses.
 * 
 * @author kevinma
 * @studentID 300867968
 * @date Sunday, October 2, 2016
 * @file Lotto.java
 *
 */

public class Lotto {
	// CONSTANTS
	// random number generator shared internally with all Lotto objects
	private final static SecureRandom RANDOM_NUMBER_GENERATOR = new SecureRandom();

	// INSTANCE VARIABLES
	private int[] _lottoNumbers;
	private int _lottoSum;

	// MUTATOR AND ACCESSOR METHODS
	public int[] getLottoNumbers() {
		return this._lottoNumbers;
	}

	public int getLottoSum() {
		return this._lottoSum;
	}

	// CONSTRUCTOR
	/**
	 * Default constructor for the Lotto class. Initializes lottoSum to 0 and
	 * lottoNumbers to an empty integer array of 3 elements
	 */
	public Lotto() {
		this._lottoNumbers = new int[3];
		this._lottoSum = 0;
	}

	// PUBLIC METHODS
	/**
	 * Generates the lottery numbers for the current iteration of the lotto.
	 * Each lotto number is added to the running sum of the current iteration.
	 */
	public void generateLottoNumbers() {
		for (int i = 0; i < this._lottoNumbers.length; i++) {
			// each lotto number generated must be between 1 to 9
			this._lottoNumbers[i] = this.RANDOM_NUMBER_GENERATOR.nextInt(9) + 1;
			this._lottoSum += this._lottoNumbers[i];
		}
	}

	/**
	 * Checks the user's guess against the lotto sum of the current iteration
	 * lotto numbers.
	 * 
	 * @param userGuess
	 *            - the sum the user chose between 3 and 27
	 * @return Whether the user wins or loses
	 */
	public boolean checkUserGuess(int userGuess) {
		return userGuess == this._lottoSum;
	}
}
