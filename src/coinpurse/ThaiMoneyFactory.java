package coinpurse;

/**
 * Create the money both coin and banknote in Thai.
 * 
 * @author Noppawan Kulchol.
 *
 */
public class ThaiMoneyFactory extends MoneyFactory {

	/**
	 * create the money of Thai. If value is less than 20, create coin. If value
	 * is more than 20, create banknote.And if it cannot create return the
	 * IllagalArgumentException
	 */
	@Override
	Valuable createMoney(double value) {

		if (build(value)) {
			if (value < 20) {
				Coin coin = new Coin(value, "Baht");
				if (value < 1) {
					coin.setPrintValue(value * 100);
					coin.setPrintCurrency("Satang");
				} else {
					coin.setPrintValue(value);
					coin.setPrintCurrency("Baht");
				}
				return coin;
			} else {
				BankNote bankNote = new BankNote(value, "Baht");
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
		double[] money = { 0.5, 0.25, 1, 2, 5, 10, 20, 50, 100, 500, 1000 };
		for (double d : money) {
			if (value == d) {
				return true;
			}
		}
		return false;

	}
}
