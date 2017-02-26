package coinpurse;

/**
 * A banknote with a monetary value and currency.
 * 
 * @author Noppawan Kulchol
 *
 */

public class BankNote extends AbstractValuable implements Valuable {
	
	
	/* Serail number of the banknote */
	private long serialNumber;
	
	/**
	 * A banknote with given value using the default currency.
	 * 
	 * @param value
	 */
	public BankNote(double value) {
		super(value,DEFAULT_CURRENCY);
	}

	/**
	 * A banknote with given value andF currency.
	 * 
	 * @param value
	 * @param currency
	 */
	public BankNote(double value, String currency) {
		super(value, currency);

	}

	/**
	 * Get the monetary value of this object, in its own currency.
	 * 
	 * @return the value of this object
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Get the currency of value of this object.
	 * 
	 * @return the currency of this object.
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Get the serial number of this object.
	 * 
	 * @return serial number.
	 */
	public long getSerial() {
		return serialNumber;
	}

	/**
	 * Set the serial number of this object.
	 * @param serialNumber
	 */
	public void setSerialNumber(long serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * return the value in each currency.
	 * @return value with currency.
	 */
	@Override
	public String toString() {
		return (value + "-"+currency+ " note [" + serialNumber + "]");
	}
}
