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
	 * Default Constructor for a Test object
	 */
	public Test() {
		this._numCorrectAns = 0;
		this._numIncorrectAns = 0;
		this.simulateQuestions();
	}

	// PRIVATE METHODS
	/**
	 * Returns a String object which contains the questions and answers
	 * formatted properly.
	 * 
	 * @param question
	 *            - a question in the test
	 * @param answerOptions
	 *            - the possible answers associated with the question on hand
	 * @return a formatted String containing the question and the answers
	 */
	private String formatQuestionAndAnswers(String question, String[] answerOptions) {
		return String.format("%s%n%n%-8s1. %s%n%-8s2. %s%n%-8s3. %s%n%-8s4. %s%n", question, "", answerOptions[0], "",
				answerOptions[1], "", answerOptions[2], "", answerOptions[3]);
	}

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
		int[] correctAnswers = { 3, 1, 2, 3, 4, 2 };

		// GENERATING QUESTIONS
		this._testQuestions = new TestQuestion[6];
		for (int i = 0; i < _testQuestions.length; i++) {
			this._testQuestions[i] = new TestQuestion(topicHeaders[i],
					this.formatQuestionAndAnswers(questions[i], answerOptions[i]), correctAnswers[i]);
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
	/**
	 * Interacts with the user by prompting the user repeatedly for a valid
	 * answer, and then providing feedback during the test as well as at the
	 * end.
	 */
	public void inputAnswer() {
		// local variables
		int userAnswer;
		TestQuestion currentQuestion;

		for (int questionNumber = 0; questionNumber < this.getTestQuestions().length; questionNumber++) {
			currentQuestion = this.getTestQuestions()[questionNumber];
			// used showOptionDialog here instead of showInputDialog to remove
			// the extra validation required using try-catch blocks and throwing
			// IllegalArgumentExceptions
			userAnswer = JOptionPane.showOptionDialog(null, currentQuestion.getQuestion(),
					currentQuestion.getQuestionTopic(), JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null,
					new Integer[] { 4, 3, 2, 1 }, null);
			System.out.println("You selected: " + (Math.abs(userAnswer - 4)));
		}
	}
}
