package exercise1;

import java.security.SecureRandom;

/**
 * This class simulates a test including its attributes and behaviors.
 * 
 * @author kevinma
 * @studentID 300867968
 * @date Saturday, October 1, 2016
 * @file Test.java
 *
 */

public class Test {

	// INSTANCE VARIABLES
	String[] _testQuestions;
	int _numIncorrectAns;
	int _numCorrectAns;
	int _testGrade;

	// GETTER AND SETTER METHODS
	public String[] getTestQuestions() {
		return _testQuestions;
	}

	public int getNumIncorrectAns() {
		return _numIncorrectAns;
	}

	public int getNumCorrectAns() {
		return _numCorrectAns;
	}

	public int getTestGrade() {
		return _testGrade;
	}

	// Used internally to auto calculate _testGrade
	// Do not allow external code to set these values
	private void setNumIncorrectAns(int numIncorrectAns) {
		this._numIncorrectAns = numIncorrectAns;
	}

	private void setNumCorrectAns(int numCorrectAns) {
		this._numCorrectAns = numCorrectAns;
		this._testGrade = this.getNumCorrectAns() / (this.getTestQuestions().length);
	}

	// CONSTRUCTOR
	public Test() {
		this.setNumCorrectAns(0);
		this.setNumIncorrectAns(0);
		this._testQuestions = null;
	}

	// PRIVATE METHODS

	// PUBLIC METHODS

}
