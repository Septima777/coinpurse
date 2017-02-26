package coinpurse;

/**
 * Create the money both coin and banknote in Malaysia.
 * 
 * @author Noppawan Kulchol.
 *
 */

public class MalayMoneyFactory extends MoneyFactory {

	/**
	 * create the money of Malaysia. If value is less than 1, create coin. If
	 * value is more than 1, create banknote. And if it cannot create return the
	 * IllagalArgumentException
	 */
	@Override
	Valuable createMoney(double value) {

		if (build(value)) {
			if (value < 1) {
				Coin coin = new Coin(value);
				coin.setPrintValue(value * 100);
				coin.setPrintCurrency("Sen");

				return coin;

			} else {
				BankNote bankNote = new BankNote(value, "Ringgit");
				bankNote.setSerialNumber(this.nextSerialNumber);
				this.nextSerialNumber++;
				return bankNote;
			}
		} else {
			throw new IllegalArgumentException();
		}

	}

	/**
	 * check the value of the money then create it both coin and banknote.
	 * 
	 * @param value
	 *            is the value of the money.
	 * @return true,it can create in coin or banknote. false, it cannot create
	 *         in coin or banknote.
	 */
	private boolean build(double value) {
		double[] money = { 0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 20, 50, 100 };
		for (double d : money) {
			if (value == d) {
				return true;
			}
		}
		return false;

	}
}
