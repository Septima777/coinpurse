package coinpurse;

/**
 * a coin with a monetary value and currency
 * @author Noppawan Kulchol
 *
 */
public class Coin implements Comparable<Coin> {

	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	private double value;
	/** The currency, of course. */
	private String currency;

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

	/** get the value in the purse. */
	public double getValue() {
		return this.value;
	}

	/** return the current. */
	public String getCurrency() {
		 return this.currency;
	}

	/**  check  2 coins that are equals in the same value and currency.*/
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (obj.getClass() != this.getClass())
			return false;
		Coin coin = (Coin) obj;
		if ((this.value == coin.value) && (this.currency == coin.currency))
			return true;
		return false;

	}

	/** compare the value between some coin and the other coin. */
	@Override
	public int compareTo(Coin coin) {
		if (coin == null)
			return -1;
		if (this.value < coin.value)
			return -1;
		if (this.value > coin.value)
			return 1;
		return 0;
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
