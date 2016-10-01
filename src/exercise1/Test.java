package exercise1;

import java.security.SecureRandom;
import javax.swing.JOptionPane;

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
	private TestQuestion[] _testQuestions;
	private int _numIncorrectAns;
	private int _numCorrectAns;
	private int _testGrade;

	// Random number generator, shared between all Test objects
	// only used internally to determine message to display to user
	private final static SecureRandom randomNumGen = new SecureRandom();

	// GETTER AND SETTER METHODS
	public TestQuestion[] getTestQuestions() {
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
	private void setNumCorrectAns(int numCorrectAns) {
		this._numCorrectAns = numCorrectAns;
		this._testGrade = this.getNumCorrectAns() / (this.getTestQuestions().length);
	}

	// CONSTRUCTORS
	/**
	 * Constructor for a Test object
	 */
	public Test() {
		this._numCorrectAns = 0;
		this._numIncorrectAns = 0;
		this.simulateQuestions();
	}

	// PRIVATE METHODS
	/**
	 * Simulates the set of questions to be used for the Test object.
	 */
	private void simulateQuestions() {
		// Hard-coded the questions and answers as per assignment requirements
		// The Q&A can be entered by user interactions with slight modification
		// to this method

		// TEMPORARY VARIABLES
		// Temporary variable storing question topics
		String[] topicHeaders = { "Procedural Programming vs Object-Oriented Programming", "Data Hiearchy",
				"Phases of Running a Java Application", "Brief Introduction to GUI",
				"Brief Introduction to GUI (Continued)", "Static Variables" };

		// Temporary variable storing questions
		String[] questions = { "What is NOT true about OOP (Object-Oriented Programming)?",
				"What is the correct hiearchy of data (from smallest to largest)?",
				"What is the correct order of the different phases?",
				"How do you output a message to the screen (NOT to the console)?",
				"How do you prompt the user for input using a GUI (Graphical User Interface)?",
				"Why do we need to declare variables as static?" };

		// Temporary variable storing answers
		String[][] answerOptions = {
				new String[] { "promotes code reusability", "promotes enhanced security due to data encapsulation",
						"uses structures, often called structs, to package different data types into a single entity",
						"uses classes to package different data types, along with different functions which manipulate the data memebers of the class into a single entity" },
				new String[] { "Bit, Character, Field, Record, File", "Character, Bit, Record,File,Field",
						"Bit, Character, Record, Field, File", "Character, Field, Record, File, Bit" },
				new String[] { "Creating the Program, Compiling into Bytecode, Execution",
						"Creating the Program, Compiling into Bytecode, Loading into memory, Bytecode verification, Execution",
						"Creating the Program, Loading into memory, Execution", "Creating the Program, Execution" },
				new String[] { "System.Out.WriteLine(message);", "System.out.println(message);",
						"JOptionPane.showMessageDialog(null, message);", "JOptionPane.showMessageDialog(message);" },
				new String[] { "input = Console.ReadLine();", "input = GUI.ReadLine();",
						"input = JOptionPane.getInputDialog(promptMessage);",
						"input = JOptionPane.showInputDialog(promptMessage);" },
				new String[] { "To enable static methods to use them",
						"To allow static methods to use them and to store class-wide information",
						"To be more professional", "To conform to proper Java naming conventions" } };

		// Temporary variable storing correct answer indexes
		int[] correctAnswers = { 2, 0, 1, 2, 3, 1 };

		// GENERATING QUESTIONS
		this._testQuestions = new TestQuestion[6];
		for (int i = 0; i < _testQuestions.length; i++) {
			this._testQuestions[i] = new TestQuestion(topicHeaders[i], questions[i], answerOptions[i],
					correctAnswers[i]);
		}
	}

	/**
	 * Checks the answer submitted by the user against the correct answer and
	 * displays an appropriate message for the user
	 * 
	 * @param question
	 *            - the test question to be checked against
	 * @param submittedAnswer
	 *            - the answer to be verified against the question on hand
	 */
	private void checkAnswer(TestQuestion question, int submittedAnswer) {
		if (question.getCorrectAnswer() == submittedAnswer) {
			this.setNumCorrectAns(this.getNumCorrectAns() + 1);
			this.generateMessage(true);
		} else {
			++this._numIncorrectAns;
			this.generateMessage(false);
		}
	}

	/**
	 * Displays a random message for the user depending on whether their answer
	 * submitted was correct or incorrect.
	 * 
	 * @param isAnswerCorrect
	 *            - determines the appropriate message to display to the user
	 */
	private void generateMessage(boolean isAnswerCorrect) {
		switch (this.randomNumGen.nextInt(4)) {
		case 0:
			JOptionPane.showMessageDialog(null, isAnswerCorrect ? "Excellent!" : "No. Please try again");
			break;
		case 1:
			JOptionPane.showMessageDialog(null, isAnswerCorrect ? "Good!" : "Wrong. Try once more");
			break;
		case 2:
			JOptionPane.showMessageDialog(null, isAnswerCorrect ? "Keep up the good work!" : "Don't give up!");
			break;
		case 3:
			JOptionPane.showMessageDialog(null, isAnswerCorrect ? "Nice work!" : "No. Keep trying...");
			break;
		}
	}

	// PUBLIC METHODS
	/**
	 * Prompts the user for his/her answer to the provided question. An
	 * exception is thrown if answer out of bounds.
	 * 
	 * @param questionNumber
	 *            - the particular question the user is being prompted to answer
	 * @return The answer entered by the user, has to be an integer between 1-4
	 */
	public int inputAnswer(int questionNumber) {
		int input = Integer
				.parseInt(JOptionPane.showInputDialog(this.getTestQuestions()[questionNumber].getQuestion()));

		do {
			try {
				if (input < 1 || input > 4)
					throw new IllegalArgumentException("ERROR - You must enter an integer between 1 to 4.");
			} catch (IllegalArgumentException e) {

			}
		} while (input < 1 || input > 4);

		return input;
	}
}
