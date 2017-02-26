package coinpurse;

/**
 * For build a Factory that can create money.
 * 
 * @author Noppawan Kulchol
 */
public abstract class MoneyFactory {

	/* default Serial number */
	protected long nextSerialNumber = 1000000;

	/* declare MoneyFactory to be static for use in every class. */
	private static MoneyFactory moneyFactory;

	/**
	 * For build the Factory and just one factory.
	 * 
	 * @return moneyfactory.
	 */
	static MoneyFactory getInstance() {
		return moneyFactory;
	}

	/**
	 * For change the factory in each country such as Thailand, Malaysia.
	 * 
	 * @param factory
	 *            such as ThaiMoneyFactory , MalayMoneyFactory.
	 */
	public static void setMoneyFactory(MoneyFactory factory) {
		MoneyFactory.moneyFactory = factory;
	}

	/**
	 * can create money both Thailand and Malaysia in different value and
	 * currency.
	 * 
	 * @param value
	 *            is value of money.
	 * @return value and currency.
	 */
	abstract Valuable createMoney(double value);

	/**
	 * for the user input the value in String, I have to change the String to
	 * Double. and if it does not exact the condition return
	 * IllegalArgumentException.
	 * 
	 * @param value
	 *            is the value of money.
	 * @return value in Double.
	 */
	Valuable createMoney(String value) {

		try {
			return createMoney(Double.parseDouble(value));

		} catch (Exception e) {
			throw new IllegalArgumentException();
		}

	}

}
