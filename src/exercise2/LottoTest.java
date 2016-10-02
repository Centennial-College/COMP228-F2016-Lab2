package exercise2;

import javax.swing.JOptionPane;

/**
 * This will be the driver class to test the implementation of the Lotto class
 * 
 * @author kevinma
 * @studentID 300867968
 * @date Saturday, October 1, 2016
 * @file LottoTest.java
 *
 */

public class LottoTest {

	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		boolean validSum = false;
		int userGuess = 0;

		// lotto game runs 5 times
		for (int lottoRunNumber = 1; lottoRunNumber <= 5; lottoRunNumber++) {
			// validation of user input - repeatedly prompt user for valid input
			// while providing feedback on errors
			do {
				try {
					// ensures that the user enters an integer
					userGuess = Integer.parseInt(JOptionPane.showInputDialog(null,
							"Please enter in your guess as an integer between 3 to 27:",
							String.format("%s %d", "Lotto Game Run#:", lottoRunNumber), JOptionPane.QUESTION_MESSAGE));

					// ensures that user inputs an integer between 3 and 27
					if (userGuess > 27 || userGuess < 3) {
						throw new IllegalArgumentException();

						// throw new IllegalArgumentException("ERROR - You must
						// enter an integer between 3 to 27.\nPlease try
						// again!");
					}
					validSum = true;
				}
				// can simply use one catch here, because we want to handle all
				// the different exceptions the same way for this application
				catch (Exception e) {
					validSum = false;
					JOptionPane.showMessageDialog(null,
							"ERROR - You must enter an integer between 3 to 27.\nPlease try again!", "Invalid Input",
							JOptionPane.ERROR_MESSAGE);
				}

				// catch (NumberFormatException e) {
				// validSum = false;
				// JOptionPane.showMessageDialog(null, e.getMessage(), "Invalid
				// Input", JOptionPane.ERROR_MESSAGE);
				// } catch (IllegalArgumentException e) {
				// validSum = false;
				// JOptionPane.showMessageDialog(null, e.getMessage(), "Invalid
				// Input", JOptionPane.ERROR_MESSAGE);
				// }
			} while (!validSum);

			// When user inputs a valid guess submission, check against the
			// generated lotto numbers
			if (lotto.checkUserGuess(userGuess)) {
				JOptionPane.showMessageDialog(null,
						String.format(
								"You guessed that the sum of the three lotto numbers was%n%d%n%nThe lotto numbers for this iteration were%n%n%d %d %d%nThe sum of the lotto numbers was%n%d%n%nYou were correct! You win!",
								userGuess, lotto.getLottoNumbers()[0], lotto.getLottoNumbers()[1],
								lotto.getLottoNumbers()[2], lotto.getLottoSum()),
						"Congratulations!", JOptionPane.INFORMATION_MESSAGE);

				// if the user wins, the lotto game ends
				return;
			} else {
				JOptionPane.showMessageDialog(null,
						String.format(
								"You guessed that the sum of the three lotto numbers was%n%d%n%nThe lotto numbers for this iteration were%n%d %d %d%n%nThe sum of the lotto numbers was%n%d%n%nYou were incorrect! Better luck next time!%n%nYou can still play the lotto %d more time(s)",
								userGuess, lotto.getLottoNumbers()[0], lotto.getLottoNumbers()[1],
								lotto.getLottoNumbers()[2], lotto.getLottoSum(), 5 - lottoRunNumber),
						"Try again!", JOptionPane.INFORMATION_MESSAGE);

				// generate new lotto numbers for the upcoming iteration of the
				// lotto game
				lotto.generateLottoNumbers();
			}
		}
	}
}
