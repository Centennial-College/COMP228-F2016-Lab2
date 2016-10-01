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
	/**
	 * Simulates the set of questions to be used for the Test object.
	 */
	private void simulateQuestions() {

	}

	// PUBLIC METHODS
	/**
	 * Checks the answer submitted by the user against the correct answer
	 * recorded in the TestQuestion property.
	 * 
	 * @param question
	 *            - the test question to be checked against
	 * @param answer
	 *            - the answer to be verified against the question on hand
	 * @return Whether answer is correct or not.
	 */
	public boolean checkAnswer(TestQuestion question, int answer) {
		return true;
	}

	/**
	 * Displays a random message for the user depending on whether their answer
	 * submitted was correct or incorrect.
	 * 
	 * @param isAnswerCorrect
	 *            - determines the appropriate message to display to the user
	 */
	public void generateMessage(boolean isAnswerCorrect) {

	}

	/**
	 * Prompts the user for his/her answer to the provided question.
	 * 
	 * @param testQuestions
	 *            - the set of questions attributed to this test
	 * @param questionNumber
	 *            - the particular question the user is being prompted to answer
	 * @return The answer entered by the user
	 */
	public String inputAnswer(String[] testQuestions, int questionNumber) {
		return "";
	}
}
