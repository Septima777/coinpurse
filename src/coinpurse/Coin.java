package coinpurse;

/**
 * a coin with a monetary value and currency
 * @author Noppawan Kulchol
 *
 */
public class Coin extends AbstractValuable implements Valuable {

	/**
	 * A coin with given value using the default currency.
	 * 
	 * @param value
	 */
	public Coin(double value) {
		this.value = value;
		this.currency = DEFAULT_CURRENCY;
	}

	/**
	 * A coin with given value and currency.
	 * 
	 * @param value
	 * @param currency
	 */
	public Coin(double value, String currency) {
		this.currency = currency;
		this.value = value;
	}

	/** return the value in each currency*/
	public String toString() {
		return (value + "-" + currency);
	}
//	public static void main(String[] args) {
//		Coin one = new Coin(1);
//		System.out.println(one.toString());
//	}

}
