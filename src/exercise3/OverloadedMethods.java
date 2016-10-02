package exercise3;

/**
 * This class will implement three overloaded static methods. The methods will
 * have different set of parameters but perform similar functionalities. The
 * methods will be invoked in the main method and results will be displayed
 * 
 * @author kevinma
 * @studentID 300867968
 * @date Sunday, October 2, 2016
 * @file OverloadedMethods.java
 *
 */
public class OverloadedMethods {
	public static void main(String[] args) {
		double moneyInWallet = 1.25;

		System.out.printf("After initialization, I have $%.2f in my wallet.%n%n", moneyInWallet);

		moneyInWallet = addMoney(moneyInWallet, 12);

		System.out.printf("After invoking addMoney(moneyInWallet, 12), I have $%.2f in my wallet.%n%n", moneyInWallet);

		moneyInWallet = addMoney(moneyInWallet, 0.83);

		System.out.printf("After invoking addMoney(moneyInWallet, 0.83), I have $%.2f in my wallet.%n%n",
				moneyInWallet);

		moneyInWallet = addMoney(moneyInWallet, 427, 0.79);

		System.out.printf("After invoking addMoney(moneyInWallet, 427, 0.79), I have $%.2f in my wallet.%n%n",
				moneyInWallet);
	}

	/**
	 * Adds the dollars to moneyInWallet and returns the result.
	 * 
	 * @param moneyInWallet
	 *            - the money currently in the wallet
	 * @param dollars
	 *            - the # of dollars to be added to the wallet
	 * @return the new total of money in the wallet
	 */
	private static double addMoney(double moneyInWallet, int dollars) {
		return moneyInWallet + dollars;
	}

	/**
	 * Adds the cents to moneyInWallet and returns the result.
	 * 
	 * @param moneyInWallet
	 *            - the money currently in the wallet
	 * @param cents
	 *            - the # of cents to be added to the wallet
	 * @return the new total of money in the wallet
	 */
	private static double addMoney(double moneyInWallet, double cents) {
		return moneyInWallet + cents;
	}

	/**
	 * Adds the dollars and cents to moneyInWallet and returns the result.
	 * 
	 * @param moneyInWallet
	 *            - the money currently in the wallet
	 * @param dollars
	 *            - the # of dollars to be added to the wallet
	 * @param cents
	 *            - the # of cents to be added to the wallet
	 * @return the new total of money in the wallet
	 */
	private static double addMoney(double moneyInWallet, int dollars, double cents) {
		return addMoney(moneyInWallet, cents) + addMoney(moneyInWallet, dollars);
	}
}
