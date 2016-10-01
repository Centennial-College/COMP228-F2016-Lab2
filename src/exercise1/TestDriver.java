package exercise1;

import javax.swing.JOptionPane;

/**
 * This will be the driver class to test the implementation of the Test class
 * 
 * @author kevinma
 * @studentID 300867968
 * @date Saturday, October 1, 2016
 * @file TestDriver.java
 *
 */
public class TestDriver {

	public static void main(String[] args) {

		// Your main class will simply create a Test object and start the test
		// by calling inputAnswer method.

		// This sounds like it is implying everything should be done in the Test
		// class as that will be the intended behavior of the class
		Test test = new Test();
		test.inputAnswer();
	}
}
