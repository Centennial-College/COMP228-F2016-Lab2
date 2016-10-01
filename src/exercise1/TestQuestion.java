package exercise1;

/**
 * This class simulates questions to be used for a test. Each question is a
 * multiple-choice question with 4 options.
 * 
 * @author kevinma
 * @studentID 300867968
 * @date Saturday, October 1, 2016
 * @file TestQuestion.java
 *
 */

public class TestQuestion {
	// INSTATNCE VARIABLES
	private String _questionTopic;
	private String _question;
	private String[] _answerOptions;
	private int _correctAnswer;

	// GETTER AND SETTER METHODS
	public String getQuestion() {
		return _question;
	}

	public void setQuestion(String question) {
		this._question = question;
	}

	public String[] getAnswerOptions() {
		return _answerOptions;
	}

	public void setAnswerOptions(String[] answerOptions) {
		this._answerOptions = answerOptions;
	}

	public int getCorrectAnswer() {
		return _correctAnswer;
	}

	public void setCorrectAnswer(int correctAnswer) {
		this._correctAnswer = correctAnswer;
	}

	public String getQuestionTopic() {
		return _questionTopic;
	}

	public void setQuestionTopic(String questionTopic) {
		this._questionTopic = questionTopic;
	}

	// CONSTRUCTORS
	/**
	 * Constructor for a TestQuestion object.
	 * 
	 * @param questionTopic
	 *            - the topic of the question
	 * @param question
	 *            - the actual question
	 * @param answerOptions
	 *            - array of answers for the question
	 * @param correctAnswer
	 *            - the index of the correct answer in the array answerOptions
	 */
	public TestQuestion(String questionTopic, String question, String[] answerOptions, int correctAnswer) {
		this.setQuestion(question);
		this.setAnswerOptions(answerOptions);
		this.setCorrectAnswer(correctAnswer);
		this.setQuestionTopic(questionTopic);
	}
}
