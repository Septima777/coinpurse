package coinpurse;
/**
 * To eliminate duplicate code from Coin and Banknote.
 * @author Noppawan Kulchol
 *
 */

public class AbstractValuable implements Valuable,Comparable<Valuable>{

	public static final String DEFAULT_CURRENCY = "Baht";
	/** Value of the coin. */
	protected double value;
	/** The currency, of course. */
	protected String currency;

	/**
	 * for call the constructor of Coin and Banknote.
	 */
	public AbstractValuable() {
		super();
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
		Valuable val = (Valuable) obj;
		if ((this.value == val.getValue()) && (this.currency == val.getCurrency()))
			return true;
		return false;
	
	}

	/** compare the value between some value and the other value. */
	
	@Override
	public int compareTo(Valuable val) {
		if(this.currency.equals(val.getCurrency())){
			if (this.value < val.getValue())
				return -1;
			if (this.value > val.getValue())
				return 1;
			if(this.value == val.getValue())
				return 0;
		}		
		return this.currency.compareTo(val.getCurrency());
	}

}