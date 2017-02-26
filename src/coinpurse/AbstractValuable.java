package coinpurse;

/**
 * To eliminate duplicate code from Coin and Banknote.
 * 
 * @author Noppawan Kulchol
 *
 */

public class AbstractValuable implements Valuable, Comparable<Valuable> {

	/* Declare the default currency. */
	public static final String DEFAULT_CURRENCY = "Baht";

	/** The Value of the money. */
	protected double value;

	/** The currency of the money. */
	protected String currency;

	/* The Value of the money(for toString()) */
	protected double printValue;

	/* The currency of the money(for toString()) */
	protected String printCurrency;

	/**
	 * for call the constructor of Coin and Banknote.
	 */
	public AbstractValuable(double value, String currency) {
		this.value = value;
		this.currency = currency;
		this.printValue = value;
		this.printCurrency = currency;
	}

	/** get the value in the purse. */
	public double getValue() {
		return this.value;
	}

	/** return the current. */
	public String getCurrency() {
		return this.currency;
	}

	/** check 2 coins that are equals in the same value and currency. */
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Valuable val = (Valuable) obj;
		if ((this.value == val.getValue()) && (this.currency == val.getCurrency()))
			return true;
		return false;

	}

	/**
	 * Get the value of money are printed.
	 * 
	 * @return value of money are printed.
	 */
	public double getPrintValue() {
		return printValue;
	}

	/**
	 * Get the currency of money are printed.
	 * 
	 * @return currency of money are printed.
	 */
	public String getPrintCurrency() {
		return printCurrency;
	}

	/**
	 * Set the value of money are printed.
	 * 
	 * @param printValue
	 */
	public void setPrintValue(double printValue) {
		this.printValue = printValue;
	}

	/**
	 * Set the currency of money are printed.
	 * 
	 * @param printCurrency
	 */
	public void setPrintCurrency(String printCurrency) {
		this.printCurrency = printCurrency;
	}

	/**
	 * compare the value between some value and the other value.
	 * 
	 * @return -1,the value comes before. 0,the value is the same. 1,the value
	 *         comes after.
	 */
	@Override
	public int compareTo(Valuable val) {
		if (this.currency.equals(val.getCurrency())) {
			if (this.value < val.getValue())
				return -1;
			if (this.value > val.getValue())
				return 1;
			if (this.value == val.getValue())
				return 0;
		}
		return this.currency.compareTo(val.getCurrency());
	}

}